package cn.star.ak.entity;

import cn.star.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.entity.Projectile;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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

public class ShivaDance extends Projectile {
    public static final EntityDataAccessor<Integer> LIFE;
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LIFE, 20*7);

    }
    static {
        LIFE = SynchedEntityData.defineId(ShivaDance.class, EntityDataSerializers.INT);


    }
    public  int getLife(){
        return this.entityData.get(LIFE);
    }
    public void setLife(int l){
         this.entityData.set(LIFE,l);
    }
    public ShivaDance(EntityType<? extends ShivaDance> p_37248_, Level p_37249_) {
        super(p_37248_, p_37249_);

    }
    public static ShivaDance createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new ShivaDance(AKEntiteRegristrys.SD, worldIn);
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
            int anInt = getLife();
            if (anInt >= 1) {
                setLife(anInt - 1);
            }else {
                this.discard();
                LivingEntity owner = ((LivingEntity) this.getOwner());
                if (owner==null)return;
                final Vec3 _center = this.position();
                List<Entity> _entfound = this.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (var e : _entfound){
                    if (e==this)continue;

                    if (e== owner)continue;
                    if (e instanceof LivingEntity livingEntity){
                        level.sendParticles(ParticleTypes.END_ROD,livingEntity.getX(),livingEntity.getY(),livingEntity.getZ(),15,0,3,0,1);
                        e.hurt(new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_EXPLOSION), owner), (float) (owner.getAttributeValue(Attributes.ATTACK_DAMAGE)*0.3*owner.getMaxHealth()));
                        e.invulnerableTime =0;
                        level.explode(owner,livingEntity.getX(),livingEntity.getY(),livingEntity.getZ(),2, Level.ExplosionInteraction.NONE);
                    }
                }
                owner.setHealth(2);
            }
        }
        super.tick();
    }
}
