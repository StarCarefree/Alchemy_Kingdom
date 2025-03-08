package cn.star.ak.mixin;

import cn.star.ak.network.AKvaV;
import mods.flammpfeil.slashblade.capability.concentrationrank.ConcentrationRank;
import mods.flammpfeil.slashblade.capability.concentrationrank.IConcentrationRank;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConcentrationRank.class)
public abstract class RankMixin implements IConcentrationRank {
    @Override
    public void addRankPoint(LivingEntity entityIn, long point) {
        long time = entityIn.level().getGameTime();
        IConcentrationRank.ConcentrationRanks rank = getRank(time);
        var level = rank.level;
        //todo 增加血脉值判断 使用cap
        if (entityIn instanceof Player player) {
            var talent = player.getCapability(AKvaV.PLAYER_VARIABLES_CAPABILITY,null).orElseGet(null).talent;
            if (!canSkinCheek(talent,level)) {
                return;
            }
        }
        IConcentrationRank.super.addRankPoint(entityIn, point);
    }

//    @Inject(at = @At("HEAD"), method = "addRankPoint(Lnet/minecraft/world/entity/LivingEntity;J)V", cancellable = true,remap = false)
//    public void addRankPoint(LivingEntity entityIn, long rankPoint, CallbackInfo ci) {
//
//    }
    private boolean canSkinCheek(int talent,int level){
        if (talent>=4) return true;
        if (talent == 3 &&level<=5 )return true;
        if (talent ==2 && level<=4)return true;
        if (talent ==1 && level<=3)return true;
        if (talent ==0 && level<=2)return true;
        return false;
    }
}
