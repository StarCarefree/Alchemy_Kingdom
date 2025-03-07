package cn.star.ak;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = AlchemyKingdom.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER.comment("Whether to log the dirt block on common setup").define("logDirtBlock", true);

    private static final ForgeConfigSpec.IntValue UP_B_KILL_NUMBER  = BUILDER.comment("血统等级B进阶需击杀的小怪数量;The number of small monsters that need to be killed to advance to bloodline level B.").defineInRange("up_b_kill_number", 100, 1, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.ConfigValue<String> UP_S_BOSS = BUILDER.comment("血统等级A进阶需击杀的Boss;Bosses that need to be killed for advanced bloodline level A.").define("up_s_boss", "minecraft:warden");

    @SuppressWarnings("unchecked")
    public static final ForgeConfigSpec.ConfigValue<List<String>> DROP_DRAGON_CROSS_BOSS = (ForgeConfigSpec.ConfigValue<List<String>>) (Object) BUILDER
            .comment("龙骨十字的可掉落对象;Dropable objects of Dragon Cross.")
            .defineList("drop_dragon_cross_boss",
                    Arrays.asList("minecraft:ender_dragon", "modid:custom_entity"),
                    obj -> obj instanceof String);

    public static final ForgeConfigSpec.ConfigValue<String> DROP_World_Tree_BOSS = BUILDER.comment("世界树枝丫的可掉落对象;Dropable Objects on World Branches.").define("drop_world_tree_boss", "minecraft:warden");
    // a list of strings that are treated as resource locations for items
    static final ForgeConfigSpec SPEC = BUILDER.build();

    // public static boolean logDirtBlock;
    public static int up_b_kill_number ;
    public static EntityType<?> up_s_boss;
    public static List<EntityType<?>> drop_dragon_cross_boss;
    public static EntityType<?> drop_world_tree_boss;
    public static Set<Item> items;

    private static boolean validateItemName(final Object obj) {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
       // logDirtBlock = LOG_DIRT_BLOCK.get();
        up_b_kill_number = UP_B_KILL_NUMBER.get();
        try {
            drop_world_tree_boss  = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.tryParse(DROP_World_Tree_BOSS.get()));
        }
        catch (Exception e){

        }
        try {
            up_s_boss  = ForgeRegistries.ENTITY_TYPES.getValue(ResourceLocation.tryParse(UP_S_BOSS.get()));
            List<String> dragonCrossBossIds = DROP_DRAGON_CROSS_BOSS.get();
            List<EntityType<?>> dragonCrossBossEntities = new ArrayList<>();

            for (String id : dragonCrossBossIds) {
                ResourceLocation entityId = ResourceLocation.tryParse(id);
                if (entityId == null) {
                    throw new IllegalStateException("format error: " + id);
                }

                EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(entityId);
                dragonCrossBossEntities.add(entityType);
            }

            drop_dragon_cross_boss = dragonCrossBossEntities;
        }
        catch (Exception e){

        }

        // convert the list of strings into a set of items

    }
}
