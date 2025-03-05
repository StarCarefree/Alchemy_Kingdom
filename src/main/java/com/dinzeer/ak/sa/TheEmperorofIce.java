package com.dinzeer.ak.sa;

import com.dinzeer.ak.regsitry.AKEntiteRegristrys;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Comparator;
import java.util.List;

public class TheEmperorofIce {
    public static void doSlash(LivingEntity playerIn){
        Level level = playerIn.level();
        final Vec3 _center = playerIn.position();

        List<Entity> _entfound = playerIn.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        if (!_entfound.stream().filter(e -> e instanceof com.dinzeer.ak.entity.TheEmperorofIce theEmperorofIce && theEmperorofIce.getOwner() == playerIn).toList().isEmpty()){
            return;
        }
        com.dinzeer.ak.entity.TheEmperorofIce shivaDance = new com.dinzeer.ak.entity.TheEmperorofIce(AKEntiteRegristrys.TheEmperorofIceS, level);
        level.addFreshEntity(shivaDance);
        shivaDance.setOwner(playerIn);
        shivaDance.setPos(playerIn.getOnPos().getCenter());
    }
    @SubscribeEvent
    public static void damageReduce(LivingHurtEvent event){
        LivingEntity entity = event.getEntity();
        final Vec3 _center = entity.position();
        List<Entity> _entfound = entity.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        if (!_entfound.stream().filter(e -> e instanceof com.dinzeer.ak.entity.LiuliFanCity liuliFanCity&&liuliFanCity.getOwner() == entity).toList().isEmpty()){
            event.setAmount(event.getAmount()*1.3f);
            return;
        }

    }
}
