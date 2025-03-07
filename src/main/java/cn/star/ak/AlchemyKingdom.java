package cn.star.ak;

import cn.star.ak.effects.BloodBoost;
import cn.star.ak.effects.ICE;
import cn.star.ak.init.AKItems;
import cn.star.ak.regsitry.AKEntiteRegristrys;
import cn.star.ak.regsitry.AKcomboRegsitry;
import cn.star.ak.regsitry.AKslashartRegsitry;
import cn.star.ak.regsitry.LangUtil;
import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModelManager;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;



// The value here should match an entry in the META-INF/mods.toml file
@Mod(AlchemyKingdom.MODID)
public class AlchemyKingdom {
    public static ResourceLocation prefix(String path) {

        return new ResourceLocation(MODID, path);
    }

    // Define mod id in a common place for everything to reference
    public static final String MODID = "ak";
    public static final Registrate REGISTRATE = Registrate.create(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MODID);  ;
    public static final RegistryObject<CreativeModeTab> AK_ITEMS_TAB = CREATIVE_MODE_TABS.register
            ("ak_items", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.ak.ak_items")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> AKItems.DRAGON_CROSS.get().getDefaultInstance()).displayItems((parameters, output) -> {

    }).build());



    public static final RegistryObject<CreativeModeTab> AKSlashblade = CREATIVE_MODE_TABS.register("ak_slashblade",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ak.ak_slashblade")).icon(() -> {
                        ItemStack stack = new ItemStack(SBItems.slashblade);
                        stack.getCapability(ItemSlashBlade.BLADESTATE).ifPresent(s -> {
                            s.setModel(new ResourceLocation(MODID, "model/named/sin/rage/sange.obj"));
                            s.setTexture(new ResourceLocation(MODID, "model/named/sin/rage/blood.png"));
                        });
                        return stack;
                    })
                    .displayItems((parameters, tabData) -> {

                        fillBlades(tabData);
                    })
                    .build());



    private static void fillBlades(CreativeModeTab.Output output) {
        if (Minecraft.getInstance().getConnection() != null) {
            BladeModelManager.getClientSlashBladeRegistry()
                    .entrySet().stream()
                    // 步骤1：过滤空值
                    .filter(entry -> entry.getKey() != null && entry.getValue() != null)
                    // 步骤2：解析字符串为ResourceLocation并过滤命名空间
                    .filter(entry -> {
                        ResourceLocation loc = ResourceLocation.tryParse(entry.getKey().location().toString());
                        return loc != null && loc.getNamespace().equals(MODID);
                    })
                    // 步骤3：按字符串键排序
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> {
                        LOGGER.info("Registering Slashblade: {}", entry.getKey());
                        output.accept(entry.getValue().getBlade());
                    });
        }
    }

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "ak" namespace

    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MODID, "main"),
            () -> "1.0",
            s -> true,
            s -> true
    );
    private static int messageID = 0;
    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        INSTANCE.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }
    public AlchemyKingdom() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        LangUtil.registerAddlang();
        AKcomboRegsitry.COMBO_STATES.register(modEventBus);
        AKEntiteRegristrys.register(modEventBus);
        AKItems.register();
        CREATIVE_MODE_TABS.register(modEventBus);
        AKslashartRegsitry.SLASH_ARTS.register(modEventBus);
        EffectAbout.REGISTRY.register(modEventBus);
        SoundAbout.REGISTRY.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::register);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public void register(RegisterEvent event) {
        AKEntiteRegristrys.register(event);



    }
    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    public static class SoundAbout{
        public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);
        public static final RegistryObject<SoundEvent> TIME_STOP = REGISTRY.register("time_stop", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "time_stop")));
    }
    public static class EffectAbout{
        public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,MODID);
        public static final RegistryObject<BloodBoost> BLOOD_BOOST = REGISTRY.register("blood_boost", BloodBoost::new);
        public static final RegistryObject<ICE> Ice = REGISTRY.register("ice", ICE::new);
    }

}
