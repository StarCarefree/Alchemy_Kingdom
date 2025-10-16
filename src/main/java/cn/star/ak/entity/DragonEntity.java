package cn.star.ak.entity;

import cn.star.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.entity.Projectile;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;

public class DragonEntity extends EntityBlisteringSword {
    public DragonEntity(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
        this.noCulling = true;
    }

    public static DragonEntity createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new DragonEntity(AKEntiteRegristrys.DragonS, worldIn);
    }

    @Override
    public void baseTick() {
        if (getPersistentData().getInt("lifeTick") >1){
            getPersistentData().putInt("lifeTick",getPersistentData().getInt("lifeTick")-1);

        }else if (getPersistentData().getInt("lifeTick") ==1){
            this.remove(RemovalReason.DISCARDED);
        }
        super.baseTick();
    }

    @Override
    protected void onHitBlock(BlockHitResult blockraytraceresult) {
        this.discard();
        super.onHitBlock(blockraytraceresult);
    }

    @Override
    public void tick() {

        super.tick();
        if (this.level() instanceof ServerLevel serverLevel){
            serverLevel.sendParticles(ParticleTypes.FLAME,
                    this.getX(),this.getY(),this.getZ(),10,0.2,0.2,0.2,0.2);
        }

    }


}
