package cn.star.ak.init;

import cn.star.ak.AlchemyKingdom;
import cn.star.ak.init.BaoXueMessage;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class LSKeyMappings {
        public static final KeyMapping GUARD = new KeyMapping("key.ak.baoxue", GLFW.GLFW_KEY_RIGHT_CONTROL, "key.category.slashblade") {
            private boolean isDownOld = false;

            @Override
            public void setDown(boolean isDown) {
                super.setDown(isDown);
                if (isDownOld != isDown && isDown) {
                    AlchemyKingdom.INSTANCE.sendToServer(new BaoXueMessage());
                }
                isDownOld = isDown;
            }
        };

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(GUARD);


    }

    @Mod.EventBusSubscriber({Dist.CLIENT})
    public static class KeyEventListener {
        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {
            if (Minecraft.getInstance().screen == null) {
                GUARD.consumeClick();


            }
        }
    }
}
