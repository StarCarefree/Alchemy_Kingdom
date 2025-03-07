package cn.star.ak.sa;

import cn.star.ak.entity.CrazyWindyEyes;
import cn.star.ak.regsitry.AKEntiteRegristrys;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;

public class WindyEyes {
    public static void doSlash(LivingEntity playerIn){
        Level level = playerIn.level();
        final Vec3 _center = playerIn.position();

        List<Entity> _entfound = playerIn.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        if (!_entfound.stream().filter(e -> e instanceof CrazyWindyEyes crazyWindyEyes && crazyWindyEyes.getOwner() == playerIn).toList().isEmpty()){
            return;
        }
        CrazyWindyEyes crazyWindyEyes = new CrazyWindyEyes(AKEntiteRegristrys.cwee, level);
        level.addFreshEntity(crazyWindyEyes);
        crazyWindyEyes.setOwner(playerIn);
        crazyWindyEyes.setPos(playerIn.getOnPos().getCenter());
    }
}
