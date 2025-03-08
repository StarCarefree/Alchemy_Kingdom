package cn.star.ak.mixin;

import mods.flammpfeil.slashblade.capability.concentrationrank.IConcentrationRank;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IConcentrationRank.class)
public abstract class RankMixin {
    @Shadow public abstract long getRankPoint(long time);

    @Shadow public abstract IConcentrationRank.ConcentrationRanks getRank(long time);

    @Inject(at = @At("HEAD"), method = "addRankPoint(Lnet/minecraft/world/entity/LivingEntity;J)V", cancellable = true)
    public void addRankPoint(LivingEntity entityIn, long rankPoint, CallbackInfo ci) {
        long time = entityIn.level().getGameTime();
        IConcentrationRank.ConcentrationRanks rank = getRank(time);
        var level = rank.level;
        //todo 增加血脉值判断 使用cap
        if (entityIn instanceof Player player) {
            if (true) {
                ci.cancel();
            }
        }
    }
}
