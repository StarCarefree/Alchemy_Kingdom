package cn.star.ak.sa;

import cn.star.ak.entity.DragonEntity;
import cn.star.ak.entity.EntitySword;
import cn.star.ak.entity.KungunierEntity;
import cn.star.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.capability.concentrationrank.ConcentrationRankCapabilityProvider;
import mods.flammpfeil.slashblade.util.KnockBacks;
import mods.flammpfeil.slashblade.util.VectorHelper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.awt.*;

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

            if (count==1) {
                for (int i = 0; i < 4; i++) {
                    DragonEntity drive = new DragonEntity(AKEntiteRegristrys.DragonS, playerIn.level());

                    playerIn.level().addFreshEntity(drive);
                    float speed = Mth.randomBetween(drive.level().getRandom(), minSpeed, maxSpeed);

                    // 随机位置，但不要离玩家太远
                    double xOffset = Mth.randomBetween(drive.level().getRandom(), -1.0F, 1.0F);
                    double yOffset = Mth.randomBetween(drive.level().getRandom(), -1.0F, 1.0F);
                    double zOffset = Mth.randomBetween(drive.level().getRandom(), -1.0F, 1.0F);
                    drive.setPos(pos.x + xOffset, pos.y + yOffset, pos.z + zOffset);

                    drive.setDamage(damage * playerIn.getAttributeValue(Attributes.ATTACK_DAMAGE));
                    drive.startRiding(playerIn, true);
                    drive.setDelay(5);
                    drive.setSpeed(speed);
                    drive.shoot(playerIn.getLookAngle().x, playerIn.getLookAngle().y, playerIn.getLookAngle().z, 1, 0);

                    drive.setOwner(playerIn);

                    drive.getPersistentData().putInt("lifeTick", 100);
                    drive.setColor(Color.red.getRGB());
                    drive.setIsCritical(critical);
                }
            }

            if (count==2){
                EntitySword ss = new EntitySword(AKEntiteRegristrys.EntitySwordS, worldIn);

                worldIn.addFreshEntity(ss);
                ss.getPersistentData().putInt("lifeTick", 60);
                ss.setIsCritical(false);
                ss.setOwner(playerIn);

                ss.setColor(colorCode);


                ss.setRoll(0);
                ss.setDamage(0);
                ss.startRiding(playerIn, true);

                double xOffset = 0;
                double yOffset = 3;
                double zOffset = 0;
                ss.setPos(playerIn.position().add(xOffset, yOffset, zOffset));

                playerIn.playSound(SoundEvents.ENDER_DRAGON_SHOOT, 0.2F, 1.45F);
            }


        }

    }
}
