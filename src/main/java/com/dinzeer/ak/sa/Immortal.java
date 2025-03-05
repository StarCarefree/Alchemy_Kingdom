package com.dinzeer.ak.sa;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Immortal {
    public static void doSlash(LivingEntity playerIn)
    {
        if (playerIn instanceof Player) {
            Player player = (Player) playerIn;
            ItemStack heldItem = player.getMainHandItem();
            if (!heldItem.isEmpty()) {
                int cooldownTicks = 20 * 15; // 设置冷却时间为10秒（20 ticks/second）
                player.getCooldowns().addCooldown(heldItem.getItem(), cooldownTicks);
            }
        }
        playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 140, 6));
        playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 140, 3));


    }
}
