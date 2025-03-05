package com.dinzeer.ak.sa;


import com.dinzeer.ak.utils.EntityPointer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

import static com.dinzeer.ak.utils.EntityPointer.isOnRay;
import static com.dinzeer.ak.utils.EntityPointer.raycast;

public class King {
    public static void doSlash(LivingEntity playerIn) {
        LivingEntity target = EntityPointer.raycastForEntityTo(playerIn.level(), playerIn, 32, true);
        if (target == null) {
            Optional<LivingEntity> targetedEntity = EntityPointer.findTargetedEntity(playerIn, 10);
            if (targetedEntity.isEmpty()) return;
            target = targetedEntity.get();
        }
        if (target!=null){
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 4));
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 4));
            playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 2));
        }




    }


}

