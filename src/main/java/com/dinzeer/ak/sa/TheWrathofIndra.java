package com.dinzeer.ak.sa;

import com.dinzeer.ak.entity.EntityZenith12thSword;
import com.dinzeer.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class TheWrathofIndra {
    public TheWrathofIndra() {
    }

    public static void doSlash(LivingEntity playerIn, boolean critical, float speed) {
        int colorCode = (Integer)playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map((state) -> {
            return state.getColorCode();
        }).orElse(-13421569);
        doSlash(playerIn, colorCode, critical, speed);
    }

    public static void doSlash(LivingEntity playerIn, int colorCode, boolean critical, float speed) {
        if (!playerIn.level().isClientSide()) {
            playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {
                Level worldIn = playerIn.level();
                    int count = 36 ;
                for (int i = 0; i < count; ++i) {
                    EntityZenith12thSword ss = new EntityZenith12thSword(AKEntiteRegristrys.EntityZenith12thsword, worldIn);
                    worldIn.addFreshEntity(ss);
                    if (state.getKillCount() >= 200) {
                        ss.setDamage(20);
                    }  else {
                        ss.setDamage(10);
                    }
                    ss.setSpeed(speed);
                    if (state.getTargetEntity(worldIn) != null){
                        ss.setNoClip(true);
                    } else {
                        ss.setNoClip(false);
                    }
                    ss.setIsCritical(critical);
                    ss.setOwner(playerIn);
                    ss.setColor(16766720);
                    ss.setRoll(90F);
                    ss.startRiding(playerIn, true);
                    ss.setDelay(3+i/4);
                    boolean isRight = ss.getDelay() % 2 == 0;
                    RandomSource random = worldIn.random;
                    double xOffset = random.nextDouble() * 2.5 * (isRight ? 1 : -1);
                    double yOffset = random.nextFloat() * 2;
                    double zOffset = random.nextFloat() * 0.5;
                    if (!(state.getTargetEntity(worldIn) == null)){
                        ss.setPos(state.getTargetEntity(worldIn).getEyePosition().add(xOffset, yOffset, zOffset));
                    } else {
                        ss.setPos(playerIn.getEyePosition().add(xOffset, yOffset, zOffset));
                    }
                    ss.setOffset(new Vec3(xOffset, yOffset, zOffset));
                    playerIn.playSound(SoundEvents.ENDER_DRAGON_FLAP, 0.2F,1.45F);
                }
            });
        }
    }
}
