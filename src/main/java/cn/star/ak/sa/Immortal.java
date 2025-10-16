package cn.star.ak.sa;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class Immortal {
    private static final Map<LivingEntity, Long> cooldownMap = new HashMap<LivingEntity, Long>();
    private static final int COOLDOWN_MILLIS = 10000;
    public static void doSlash(LivingEntity playerIn) {

        if (playerIn instanceof Player player) {
            long currentTime = System.currentTimeMillis();
            if (cooldownMap.containsKey(player)) {
                long lastUsedTime = cooldownMap.get(player);
                if (currentTime - lastUsedTime < COOLDOWN_MILLIS) {
                    Component akcd1 = Component.translatable("message.ak.cloud.cooldown");
                    Component akcd2 = Component.translatable("message.ak.cloud.cooldown.s");

                    long remainingTime = 10 - ((currentTime - lastUsedTime) / 1000);
                        if (remainingTime < 10) {
                            Component message = akcd1.copy()
                                    .append(Component.literal(" " + remainingTime + " "))
                                    .append(akcd2)
                                    .withStyle(ChatFormatting.RED);

                            player.displayClientMessage(message, true);
                        }
                            return;
                }
            }
            playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 180, 6));
            playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 180, 3));

            cooldownMap.put(playerIn, currentTime);
        }
    }
}
