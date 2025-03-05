package com.dinzeer.ak.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.world.item.ItemStack;

public class HasSins {
    public static boolean hasTran(ItemStack stack, String effect) {
        CompoundTag tag = stack.getOrCreateTag(); // 获取或创建NBT标签

        if (tag.contains("bladeState")) { // 检查是否存在ForgeCaps标签
            CompoundTag forgeCaps = tag.getCompound("bladeState");

            if (forgeCaps.contains("SpecialAttackType")) { // 检查SpecialEffects标签
                String translationKey = forgeCaps.getString("SpecialAttackType"); // 8表示String类型
                  if (translationKey.equals(effect)){
                      return true;
                  }

            }

        }
        return false; // 没有找到指定的特殊效果
    }
}
