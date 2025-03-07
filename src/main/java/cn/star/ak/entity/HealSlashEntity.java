package cn.star.ak.entity;

import cn.star.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.entity.EntitySlashEffect;
import mods.flammpfeil.slashblade.entity.Projectile;
import mods.flammpfeil.slashblade.util.KnockBacks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;

public class HealSlashEntity extends EntitySlashEffect {

    public HealSlashEntity(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);

    }
    public static HealSlashEntity createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new HealSlashEntity(AKEntiteRegristrys.HealSlash, worldIn);
    }
    protected void onHitEntity(EntityHitResult p_213868_1_) {
        Entity targetEntity = p_213868_1_.getEntity();
        if (targetEntity instanceof LivingEntity a) {
            KnockBacks.cancel.action.accept((LivingEntity) targetEntity);
            StunManager.setStun((LivingEntity) targetEntity);
            a.invulnerableTime = 0;
        }
        if (this.getShooter() instanceof LivingEntity entity) {
            // 恢复源实体的生命值
            if (entity != null && entity.isAlive()) {
                entity.heal((float) (entity.getMaxHealth() * 0.07));
            }
            super.onHitEntity(p_213868_1_);
        }
    }

}
