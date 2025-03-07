package cn.star.ak.sa;

import cn.star.ak.regsitry.AKEntiteRegristrys;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Comparator;
import java.util.List;
@Mod.EventBusSubscriber
public class LiulifanCity {
    public static void doSlash(LivingEntity playerIn){
        Level level = playerIn.level();
        final Vec3 _center = playerIn.position();

        List<Entity> _entfound = playerIn.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        if (!_entfound.stream().filter(e -> e instanceof cn.star.ak.entity.LiuliFanCity liuliFanCity && liuliFanCity.getOwner() == playerIn).toList().isEmpty()){
            return;
        }
        cn.star.ak.entity.LiuliFanCity shivaDance = new cn.star.ak.entity.LiuliFanCity(AKEntiteRegristrys.LC, level);
        level.addFreshEntity(shivaDance);
        shivaDance.setOwner(playerIn);
        shivaDance.setPos(playerIn.getOnPos().getCenter());
    }
    @SubscribeEvent
    public static void damageReduce(LivingHurtEvent event){
        LivingEntity entity = event.getEntity();
        final Vec3 _center = entity.position();
        List<Entity> _entfound = entity.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        if (!_entfound.stream().filter(e -> e instanceof cn.star.ak.entity.LiuliFanCity liuliFanCity&&liuliFanCity.getOwner() == entity).toList().isEmpty()){
            event.setAmount((float) Math.max(0,event.getAmount() - entity.getMainHandItem().getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE).stream()
                    .mapToDouble(attributeModifier -> attributeModifier.getAmount()).sum() *3 ));
            return;
        }

    }
}
