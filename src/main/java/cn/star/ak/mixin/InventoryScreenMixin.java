package cn.star.ak.mixin;


import cn.star.ak.network.AKvaV;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.CraftingScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(InventoryScreen.class)
public class InventoryScreenMixin {

    @Inject(at = @At("HEAD"), method = "renderBg")
    public void render(GuiGraphics gg, float p, int p_283078_, int p_283647_, CallbackInfo ci) {
        Minecraft instance = Minecraft.getInstance();
        InventoryScreen inventoryScreen = (InventoryScreen) (Object) this;

        int talent = instance.player.getCapability(AKvaV.PLAYER_VARIABLES_CAPABILITY).orElseGet(null).talent;
        if (talent !=0) {
            Font font = instance.font;
            var component  = Component.empty();
            if (talent == 1){
                component = Component.translatable("gui.ak.blood","B");
            }
            if (talent == 2){
                component = Component.translatable("gui.ak.blood","A");
            }
            if (talent == 3){
                component = Component.translatable("gui.ak.blood","S");
            }
            if (talent == 4){
                component = Component.translatable("gui.ak.blood","S+");
            }
            gg.pose().pushPose();
            int a = inventoryScreen.getGuiLeft();
            int b = inventoryScreen.getGuiTop();
            gg.pose().translate(a , b, 100);
            gg.drawString(font, component, 139, 15, Color.white.getRGB());
            gg.pose().popPose();
        }
    }
}
