package com.dinzeer.ak.entity;

import com.dinzeer.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.entity.Projectile;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

import java.util.Comparator;
import java.util.List;

public class LiuliFanCity extends Projectile {

    public LiuliFanCity(EntityType<? extends LiuliFanCity> p_37248_, Level p_37249_) {
        super(p_37248_, p_37249_);
        this.getPersistentData().putInt("deadtick",20*15);
    }
    public static LiuliFanCity createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new LiuliFanCity(AKEntiteRegristrys.LC, worldIn);
    }
    public static void sendParticleCircleN(ServerLevel level, Vec3 pos, SimpleParticleType particleType, float radius, int count) {


        RandomSource random = RandomSource.create(); // 创建随机数生成器

        for (int i = 0; i < count; i++) {
            // 计算角度
            double angle = i * (2 * Math.PI / count);

            // 在圆周上计算粒子位置
            double offsetX = radius * Math.cos(angle);
            double offsetZ = radius * Math.sin(angle);

            // 添加一点随机偏移，使粒子分散
            offsetX += random.nextDouble() * 0.1 - 0.05;
            offsetZ += random.nextDouble() * 0.1 - 0.05;

            // 发送粒子
            level.sendParticles(particleType, pos.x + offsetX, pos.y+0.5, pos.z + offsetZ, 1, 0.0, 0.0, 0.0, 0.05);
        }
    }
    /**
     * 让一个实体围绕另一个实体做圆周运动。
     *
     * @param follower 跟随的实体。
     * @param leader 被跟随的实体。
     * @param radius 圆周运动的半径。
     * @param speed 旋转速度（每秒的旋转角度）。
     */
    public static void orbitAroundEntity(Entity follower, Entity leader, double radius, float speed) {
        Vec3 leaderPos = leader.position();
        Vec3 followerPos = follower.position();

        // 计算当前的偏移角度
        double offsetX = followerPos.x - leaderPos.x;
        double offsetZ = followerPos.z - leaderPos.z;
        double currentAngle = Math.toDegrees(Math.atan2(offsetZ, offsetX)) - 90.0D;

        // 计算新的角度
        double newAngle = currentAngle + speed;

        // 根据新角度计算新的位置
        double newX = leaderPos.x + radius * Math.cos(Math.toRadians(newAngle));
        double newZ = leaderPos.z + radius * Math.sin(Math.toRadians(newAngle));

        // 设置跟随实体的新位置
        follower.setPos(newX, leaderPos.y, newZ);

        // 设置跟随实体的朝向
        float yaw = (float) newAngle;
        follower.setYRot(yaw);
        follower.setYHeadRot(yaw);
    }
    @Override
    public void tick() {
        if (this.level() instanceof ServerLevel level) {
            int anInt = this.getPersistentData().getInt("deadtick");
            if (anInt >=1){
                this.getPersistentData().putInt("deadtick",anInt-1);
            }else this.remove(RemovalReason.DISCARDED);
            Vec3 pos = this.position();
            LivingEntity owner = ((LivingEntity) getOwner());
            if (owner != null) {
                orbitAroundEntity(this, owner, 4, 0.5f);
            }
            sendParticleCircleN(level, new Vec3(pos.x,pos.y,pos.z), ParticleTypes.GLOW_SQUID_INK, 1, 2);
            sendParticleCircleN(level, new Vec3(pos.x,pos.y+1,pos.z), ParticleTypes.GLOW_SQUID_INK, 1f, 2);
            sendParticleCircleN(level, new Vec3(pos.x,pos.y+2,pos.z), ParticleTypes.GLOW_SQUID_INK, 1f, 2);
            sendParticleCircleN(level, new Vec3(pos.x,pos.y+3,pos.z), ParticleTypes.GLOW_SQUID_INK, 1f, 2);


      //      final Vec3 _center = this.position();


        }
        super.tick();
    }
}
