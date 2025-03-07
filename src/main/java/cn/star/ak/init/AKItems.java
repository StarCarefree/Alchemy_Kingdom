package cn.star.ak.init;

import cn.star.ak.AlchemyKingdom;
import cn.star.ak.content.talent.handle.TalentHandle;
import cn.star.ak.network.AKvaV;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import dev.xkmc.l2complements.init.data.LangData;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

import java.util.function.BiFunction;
import java.util.function.Supplier;

import static cn.star.ak.AlchemyKingdom.REGISTRATE;

public class AKItems {
    public static final ItemEntry<DragonCross> DRAGON_CROSS;
    public static final ItemEntry<UnknownSecretSauce> UNKNOWN_SECRET_SAUCE;
    public static final ItemEntry<Item> geM=itemInit("gem",Rarity.EPIC);
    public static final ItemEntry<Item> worldtree=itemInit("worldtree",Rarity.EPIC);
    public static class DragonCross extends Item{
        public DragonCross(Properties properties){
            super(properties);
        }

        @Override
        public InteractionResultHolder<ItemStack> use(Level p_41432_1, Player p_41399_, InteractionHand p_41434_) {
                ItemStack p_41432_ ;
                p_41432_ = p_41399_.getItemInHand(p_41434_);
            if (TalentHandle.getTalent(p_41399_) ==3){
                TalentHandle.setTalent(p_41399_,4);
                p_41432_.shrink(1);
                p_41399_.sendSystemMessage(Component.translatable("message.ak.talent.up_S+"));
                return InteractionResultHolder.success(p_41432_);
            }
            return super.use(p_41432_1, p_41399_, p_41434_);
        }

    }
    public static class UnknownSecretSauce extends Item{
        public UnknownSecretSauce(Properties properties){
            super(properties);
        }

        @Override
        public InteractionResultHolder<ItemStack> use(Level p_41432_1, Player p_41399_, InteractionHand p_41434_) {
            ItemStack p_41432_ ;
            p_41432_ = p_41399_.getItemInHand(p_41434_);
            AKvaV.PlayerVariables playerVariables = p_41399_.getCapability(AKvaV.PLAYER_VARIABLES_CAPABILITY).orElse(null);
            boolean mixin = playerVariables.mixin;
            if (!mixin){
                playerVariables.mixin =true;
                playerVariables.syncPlayerVariables(p_41399_);
                p_41432_.shrink(1);
                p_41399_.sendSystemMessage(Component.translatable("message.ak.useMixin"));
                return InteractionResultHolder.success(p_41432_);
            }
            return super.use(p_41432_1, p_41399_, p_41434_);
        }

    }
    static {

        {
            DRAGON_CROSS =
            REGISTRATE.item(
                    "dragon_cross", DragonCross::new
            ).properties(properties -> properties.rarity(Rarity.EPIC)).tab(AlchemyKingdom.AK_ITEMS_TAB.getKey()).defaultModel().defaultLang().register();

            UNKNOWN_SECRET_SAUCE=
                    REGISTRATE.item(
                            "unknown_secret_sauce", UnknownSecretSauce::new
                    ).properties(properties -> properties.rarity(Rarity.EPIC)).tab(AlchemyKingdom.AK_ITEMS_TAB.getKey()).defaultModel().defaultLang().register();


        }


    }
    private static <T extends Item> ItemEntry<T> reg(String name, NonNullFunction<Item.Properties, T> factory) {
        return REGISTRATE.item(name,factory).register();
    }

    public static void register() {
    }

    public static ItemEntry<Item> itemInit(String name,Rarity rarity){
        return REGISTRATE.item(
                name, Item::new
        ).properties(properties -> properties.rarity(rarity)).tab(AlchemyKingdom.AK_ITEMS_TAB.getKey()).defaultModel().defaultLang().register();


    }
}
