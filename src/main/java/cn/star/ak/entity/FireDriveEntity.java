package cn.star.ak.entity;



import cn.star.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.entity.Projectile;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;

public class FireDriveEntity extends EntityDrive {
    public FireDriveEntity(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public static FireDriveEntity createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new FireDriveEntity(AKEntiteRegristrys.FireDrive, worldIn);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level() instanceof ServerLevel serverLevel){
            serverLevel.sendParticles(ParticleTypes.FLAME,
                    this.getX(),this.getY(),this.getZ(),10,0.2,0.2,0.2,0.2);
        }

    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        if (entity.isOnFire() && entity.isAlive()) {
            entity.extinguishFire();
        }

    }
}
