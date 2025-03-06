package com.dinzeer.ak.sa;

import com.dinzeer.ak.entity.DragonEntity;
import com.dinzeer.ak.entity.EntitySword;
import com.dinzeer.ak.entity.KungunierEntity;
import com.dinzeer.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.capability.concentrationrank.ConcentrationRankCapabilityProvider;
import mods.flammpfeil.slashblade.util.KnockBacks;
import mods.flammpfeil.slashblade.util.VectorHelper;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Dragon {
    public static void doSlash(LivingEntity playerIn, float roll, int lifetime, Vec3 centerOffset,
                               boolean critical, double damage, float minSpeed, float maxSpeed, int count,int cc) {
        doSlash(playerIn, roll, lifetime, centerOffset, critical, damage, KnockBacks.cancel, minSpeed, maxSpeed, count,cc);

    }

    public static void doSlash(LivingEntity playerIn, float roll, int lifetime, Vec3 centerOffset,
                               boolean critical, double damage, KnockBacks knockback, float minSpeed, float maxSpeed, int count,int cc) {
        int colorCode = cc;
        doSlash(playerIn, roll, lifetime, colorCode, centerOffset, critical, damage, knockback, minSpeed, maxSpeed, count);
    }

    public static void doSlash(LivingEntity playerIn, float roll, int lifetime, int colorCode, Vec3 centerOffset,
                               boolean critical, double damage, KnockBacks knockback, float minSpeed, float maxSpeed, int count) {

        if (playerIn.level().isClientSide()) return;

        Vec3 pos = playerIn.position().add(0.0D, (double) playerIn.getEyeHeight() * 0.75D, 0.0D)
                .add(playerIn.getLookAngle().scale(0.3f));

        pos = pos.add(VectorHelper.getVectorForRotation(-90.0F, playerIn.getViewYRot(0)).scale(centerOffset.y))
                .add(VectorHelper.getVectorForRotation(0, playerIn.getViewYRot(0) + 90).scale(centerOffset.z))
                .add(playerIn.getLookAngle().scale(centerOffset.z));
        {
            Level worldIn = playerIn.level();
            DragonEntity drive = new DragonEntity(AKEntiteRegristrys.DragonS, playerIn.level());

            playerIn.level().addFreshEntity(drive);
            float speed = Mth.randomBetween(drive.level().getRandom(), minSpeed, maxSpeed);

            drive.setPos(pos.x, pos.y, pos.z);
            drive.setDamage(damage);
            drive.setSpeed(speed);
            drive.shoot(playerIn.getLookAngle().x, playerIn.getLookAngle().y, playerIn.getLookAngle().z, drive.getSpeed(), 0);

            drive.setOwner(playerIn);

            drive.setRotationRoll(roll);


            drive.setColor(0);
            drive.setIsCritical(critical);
            drive.setKnockBack(knockback);
            drive.setLifetime(lifetime);

            if (playerIn != null)
                playerIn.getCapability(ConcentrationRankCapabilityProvider.RANK_POINT)
                        .ifPresent(rank -> drive.setRank(rank.getRankLevel(playerIn.level().getGameTime())));


            if (count==2){
                EntitySword ss = new EntitySword(AKEntiteRegristrys.EntitySwordS, worldIn);

                worldIn.addFreshEntity(ss);

                ss.setIsCritical(false);
                ss.setOwner(playerIn);

                ss.setColor(colorCode);


                ss.setRoll(0);
                ss.setDamage(0);
                // force riding
                ss.startRiding(playerIn, true);
                ss.setDelay(20 );
                double xOffset = 0;
                double yOffset = 3;
                double zOffset = 0;
                ss.setPos(playerIn.position().add(xOffset, yOffset, zOffset));

                playerIn.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);

            }


        }

    }
}
