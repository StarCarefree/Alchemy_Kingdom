package cn.star.ak.mixin;


import ca.weblite.objc.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.awt.*;
import java.util.Comparator;
import java.util.List;

@Mixin(Entity.class)
public class ClientEntityMixin {

    /**
     * Necessary see color glowing mob outlines while we have the echolocation effect
     */
    @Inject(method = "getTeamColor", at = @At(value = "HEAD"), cancellable = true)
    public void changeGlowOutline(CallbackInfoReturnable<Integer> cir) {
        LocalPlayer player = Minecraft.getInstance().player;
        final Vec3 _center = player.position();

        List<Entity> _entfound = player.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
        if (!_entfound.stream().filter(e -> e instanceof cn.star.ak.entity.TheEmperorofIce theEmperorofIce && theEmperorofIce.getOwner() == player).toList().isEmpty()){
            cir.setReturnValue(Color.BLUE.getRGB());
        }
    }
}
