package cn.star.ak.sa;

import cn.star.ak.AlchemyKingdom;
import cn.star.ak.utils.EntityPointer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class TimeZero {
    public static void sendParticleCircle(ServerLevel level, LivingEntity entity, SimpleParticleType particleType, float radius, int count) {
        double posX = entity.getX();
        double posY = entity.getY() + entity.getBbHeight() * 0.5;
        double posZ = entity.getZ();

        RandomSource random = RandomSource.create(); // 创建随机数生成器

        for (int i = 0; i < count; i++) {

            double angle = i * (2 * Math.PI / count);

            // 在圆周上计算粒子位置
            double offsetX = radius * Math.cos(angle);
            double offsetZ = radius * Math.sin(angle);

            // 添加一点随机偏移，使粒子分散
            offsetX += random.nextDouble() * 0.1 - 0.05;
            offsetZ += random.nextDouble() * 0.1 - 0.05;

            // 发送粒子
            level.sendParticles(particleType, posX + offsetX, posY, posZ + offsetZ, 1, 0.0, 0.0, 0.0, 0.05);
        }
    }


    public static void skill(LivingEntity player) {

        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();
        Level _level = player.level();
      //  player.getPersistentData().putInt("timess",60);
        {
            if (_level instanceof ServerLevel level) sendParticleCircle(level, player, ParticleTypes.CLOUD, 6, 56);


            if (!_level.isClientSide()) {
                _level.playSound(null, BlockPos.containing(x, y, z), AlchemyKingdom.SoundAbout.TIME_STOP.get(), SoundSource.NEUTRAL, 1, 1);
            } else {
                _level.playLocalSound(x, y, z, AlchemyKingdom.SoundAbout.TIME_STOP.get(), SoundSource.NEUTRAL, 1, 1, false);
            }


            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = player.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator!=player){
                    if (entityiterator instanceof LivingEntity entity){
                        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,20*10,4));

                    }
                }
            }
        }


    }
    public static void doSlash(LivingEntity playerIn){

    //    Vec3 _center = entity.position();
    /*    List<Entity> _entfound = playerIn.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        for (Entity entityiterator : _entfound) {
                     if (entityiterator ==entity)continue;
                    if (entityiterator instanceof LivingEntity livingEntity) {
                       livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,20*10,4));
                        if (playerIn.level() instanceof ServerLevel serverLevel) {
                            serverLevel.sendParticles(ParticleTypes.SMOKE,
                                    livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 30, 0.2, 0.2, 0.2, 0.2);


                        }
                    }
        }*/
        skill(playerIn);
        playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*10, 4));
        playerIn.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20*10, 4));


    }
}

