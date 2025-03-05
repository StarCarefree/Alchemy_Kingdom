package com.dinzeer.ak.sa;

import mods.flammpfeil.slashblade.entity.EntitySlashEffect;
import mods.flammpfeil.slashblade.util.AttackManager;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Ruins {
    public static void doSlash(LivingEntity playerIn){

        for (int a=0;a<30;a++){
            EntitySlashEffect entitySlashEffect = AttackManager.doSlash(playerIn, a*6, Vec3.ZERO, false, false,

            new Random().nextInt((a+1))*0.1f);
            if (entitySlashEffect!=null)entitySlashEffect.setBaseSize(5);


        }
        final Vec3 _center = playerIn.position();

        List<Entity> _entfound = playerIn.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        for (Entity entityiterator : _entfound) {
            if (entityiterator != playerIn) {
                    if (entityiterator instanceof LivingEntity livingEntity) {
                        entityiterator.invulnerableTime =0;
                        entityiterator.hurt(new DamageSource(playerIn.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), playerIn), (float) (playerIn.getAttributeValue(Attributes.ATTACK_DAMAGE)*10f));

                    }
            }
        }

        }
}
