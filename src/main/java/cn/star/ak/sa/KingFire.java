package cn.star.ak.sa;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.structure.templatesystem.AxisAlignedLinearPosTest;

import java.util.List;
import java.util.Random;

public class KingFire {
    public static void doSlash(LivingEntity playerIn){

         for (int a =0; a<300;a++) {
             if (playerIn.level() instanceof ServerLevel serverLevel) {
                 serverLevel.sendParticles(ParticleTypes.FLAME,
                         playerIn.getX(), playerIn.getY(), playerIn.getZ(), 5, 0.2, 0.2, 0.2, 0.2);


             }
         }

}
}
