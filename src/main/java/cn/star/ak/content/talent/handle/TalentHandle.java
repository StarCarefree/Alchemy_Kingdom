package cn.star.ak.content.talent.handle;

import cn.star.ak.Config;
import cn.star.ak.init.AKItems;
import cn.star.ak.network.AKvaV;

import cn.star.ak.utils.WeightedUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber
public class TalentHandle {
    public static int getTalent(Player player){
        AKvaV.PlayerVariables playerVariables = player.getCapability(AKvaV.PLAYER_VARIABLES_CAPABILITY).orElse(null);
        if (playerVariables==null)return 0;
        return playerVariables.talent;
    }
    public static boolean setTalent(Player player,int talentNum){
        LazyOptional<AKvaV.PlayerVariables> capability = player.getCapability(AKvaV.PLAYER_VARIABLES_CAPABILITY);
        if(!capability.isPresent())return false;
        AKvaV.PlayerVariables playerVariables = capability.orElse(null);
        playerVariables.talent = talentNum;
        playerVariables.syncPlayerVariables(player);
        return true;
    }
    private static final WeightedUtil<Integer> weightedUtil = new WeightedUtil<>(Map.of(
            1,97f,
            2,2.5f,
            3,0.5f
    ));

    @SubscribeEvent
    public static void refreshTalent(PlayerEvent.PlayerLoggedInEvent event){
        Player entity = event.getEntity();
        int n = getTalent(entity);
        if (n==0){
            setTalent(entity,weightedUtil.selectRandomKeyBasedOnWeights());
            n = getTalent(entity);
            if (n == 1){
                entity.sendSystemMessage(Component.translatable("message.ak.talent.b"));
            }
            if (n == 2){
                entity.sendSystemMessage(Component.translatable("message.ak.talent.a"));
            }
            if (n == 3){
                entity.sendSystemMessage(Component.translatable("message.ak.talent.s"));
            }

        }


    }
    @SubscribeEvent
    public static void upEvent(LivingDeathEvent event){
        if (event.getSource().getEntity() instanceof  Player player) {
            LazyOptional<AKvaV.PlayerVariables> capability = player.getCapability(AKvaV.PLAYER_VARIABLES_CAPABILITY);
            if (capability.isPresent()) {
                AKvaV.PlayerVariables playerVariables = capability.orElse(null);
                playerVariables.killCount = playerVariables.killCount +1;
                if (playerVariables.talent == 1){
                    if (playerVariables.killCount >= Config.up_b_kill_number){
                        playerVariables.talent =2;
                        player.sendSystemMessage(Component.translatable("message.ak.talent.up_A"));
                    }
                }
                LivingEntity entity = event.getEntity();
                if (playerVariables.talent == 2){
                    if (entity.getType() == Config.up_s_boss){
                        playerVariables.talent =3;
                        player.sendSystemMessage(Component.translatable("message.ak.talent.up_S"));
                    }
                }
                if (playerVariables.talent >= 3){
                    if (entity.getType() == Config.drop_dragon_cross_boss){
                        Level level = entity.level();
                        level.addFreshEntity(new ItemEntity(level,entity.getX(),entity.getY(),entity.getZ(), AKItems.DRAGON_CROSS.get().getDefaultInstance()));
                    }
                    if ( entity.getType() == Config.drop_world_tree_boss){
                        Level level = entity.level();
                        level.addFreshEntity(new ItemEntity(level,entity.getX(),entity.getY(),entity.getZ(), AKItems.worldtree.get().getDefaultInstance()));
                    }
                }
                playerVariables.syncPlayerVariables(player);
            }
        }
    }
}
