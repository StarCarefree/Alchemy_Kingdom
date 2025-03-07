package cn.star.ak.mixin;

import cn.star.ak.regsitry.AKslashartRegsitry;
import cn.star.ak.utils.HasSins;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.item.SwordType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static cn.star.ak.AlchemyKingdom.MODID;

@Mixin(ItemSlashBlade.class)
public class SwordTypeMixin {
    @Inject(method = "appendSwordType",cancellable = true,at = @At("HEAD"), remap = false)
    private  void appendSwordType(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn, CallbackInfo ci) {
        var swordType = SwordType.from(stack);
        if (swordType.contains(SwordType.BEWITCHED)&&
                HasSins.hasTran(stack,MODID+":"+ AKslashartRegsitry.Dragon.getId().getPath())) {
            tooltip.add(
                    Component.translatable("ak.sword_type.sin").withStyle(ChatFormatting.BLACK));
            ci.cancel();
            return;
        }
        if (swordType.contains(SwordType.BEWITCHED)&&
                HasSins.hasTran(stack,MODID+":"+ AKslashartRegsitry.ruins.getId().getPath())) {
            tooltip.add(
                    Component.translatable("ak.sword_type.sin").withStyle(ChatFormatting.BLACK));
            ci.cancel();
            return;
        }
        if (swordType.contains(SwordType.BEWITCHED)&&
                HasSins.hasTran(stack,MODID+":"+ AKslashartRegsitry.TheEmperorofIce.getId().getPath())) {
            tooltip.add(
                    Component.translatable("ak.sword_type.sin").withStyle(ChatFormatting.BLACK));
            ci.cancel();
            return;
        }
        if (swordType.contains(SwordType.BEWITCHED)&&
                HasSins.hasTran(stack,MODID+":"+ AKslashartRegsitry.LiulifanCity.getId().getPath())) {
            tooltip.add(
                    Component.translatable("ak.sword_type.sin").withStyle(ChatFormatting.BLACK));
            ci.cancel();
            return;
        }
        if (swordType.contains(SwordType.BEWITCHED)&&
                HasSins.hasTran(stack,MODID+":"+ AKslashartRegsitry.ShivaDance.getId().getPath())) {
            tooltip.add(
                    Component.translatable("ak.sword_type.sin").withStyle(ChatFormatting.BLACK));
            ci.cancel();
            return;
        }
        if (swordType.contains(SwordType.BEWITCHED)&&
                HasSins.hasTran(stack,MODID+":"+ AKslashartRegsitry.WindyEyes.getId().getPath())) {
            tooltip.add(
                    Component.translatable("ak.sword_type.sin").withStyle(ChatFormatting.BLACK));
            ci.cancel();
            return;
        }
        if (swordType.contains(SwordType.BEWITCHED)&&
                HasSins.hasTran(stack,MODID+":"+ AKslashartRegsitry.TheWrathofIndra.getId().getPath())) {
            tooltip.add(
                    Component.translatable("ak.sword_type.sin").withStyle(ChatFormatting.BLACK));
            ci.cancel();
            return;
        }
        if (swordType.contains(SwordType.BEWITCHED)&&
                HasSins.hasTran(stack,MODID+":"+ AKslashartRegsitry.Fate.getId().getPath())) {
            tooltip.add(
                    Component.translatable("ak.sword_type.fate").withStyle(ChatFormatting.LIGHT_PURPLE));
            ci.cancel();
            return;
        }
        if (swordType.contains(SwordType.BEWITCHED)&&
                HasSins.hasTran(stack,MODID+":"+ AKslashartRegsitry.Immortal.getId().getPath())) {
            tooltip.add(
                    Component.translatable("ak.sword_type.king").withStyle(ChatFormatting.RED));
            ci.cancel();
            return;
        }
    }

}
