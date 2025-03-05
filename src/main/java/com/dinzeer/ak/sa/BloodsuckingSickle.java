package com.dinzeer.ak.sa;

import com.dinzeer.ak.entity.HealSlashEntity;
import com.dinzeer.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.capability.concentrationrank.ConcentrationRankCapabilityProvider;
import mods.flammpfeil.slashblade.entity.EntitySlashEffect;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.slasharts.SakuraEnd;
import mods.flammpfeil.slashblade.util.KnockBacks;
import mods.flammpfeil.slashblade.util.VectorHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class BloodsuckingSickle {
    public static HealSlashEntity doSlash(LivingEntity playerIn, float roll, Vec3 centerOffset, boolean mute, boolean critical, double damage) {
        return doSlash(playerIn, roll, centerOffset, mute, critical, damage, KnockBacks.cancel);
    }

    public static HealSlashEntity doSlash(LivingEntity playerIn, float roll, Vec3 centerOffset, boolean mute, boolean critical, double damage, KnockBacks knockback) {
        int colorCode = (Integer)playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map((state) -> {
            return state.getColorCode();
        }).orElseGet(() -> {
            return 16777215;
        });
        return doSlash(playerIn, roll, colorCode, centerOffset, mute, critical, damage, knockback);
    }

    public static HealSlashEntity doSlash(LivingEntity playerIn, float roll, int colorCode, Vec3 centerOffset, boolean mute, boolean critical, double damage, KnockBacks knockback) {
        if (playerIn.level().isClientSide()) {
            return null;
        } else {
            Vec3 pos = playerIn.position().add(0.0, (double)playerIn.getEyeHeight() * 0.75, 0.0).add(playerIn.getLookAngle().scale(0.30000001192092896));
            pos = pos.add(VectorHelper.getVectorForRotation(-90.0F, playerIn.getViewYRot(0.0F)).scale(centerOffset.y)).add(VectorHelper.getVectorForRotation(0.0F, playerIn.getViewYRot(0.0F) + 90.0F).scale(centerOffset.z)).add(playerIn.getLookAngle().scale(centerOffset.z));
            HealSlashEntity jc = new HealSlashEntity(AKEntiteRegristrys.HealSlash, playerIn.level());
            jc.setPos(pos.x, pos.y, pos.z);
            jc.setOwner(playerIn);
            jc.setRotationRoll(roll);
            jc.setYRot(playerIn.getYRot());
            jc.setXRot(0.0F);
            jc.setColor(colorCode);
            jc.setMute(mute);
            jc.setIsCritical(critical);
            jc.setDamage(damage);
            jc.setKnockBack(knockback);
            if (playerIn != null) {
                playerIn.getCapability(ConcentrationRankCapabilityProvider.RANK_POINT).ifPresent((rank) -> {
                    jc.setRank(rank.getRankLevel(playerIn.level().getGameTime()));
                });
            }

            playerIn.level().addFreshEntity(jc);
            return jc;
        }
    }
}
