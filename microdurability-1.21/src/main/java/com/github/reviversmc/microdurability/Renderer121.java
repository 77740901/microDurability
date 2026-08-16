package com.github.reviversmc.microdurability;

import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

public class Renderer121 extends Renderer1205 {
	@Override
	protected boolean hasMending(Object stack) {
		return EnchantmentHelper.getEffect((ItemStack) stack, EnchantmentEffectComponentTypes.REPAIR_WITH_XP).isPresent();
	}
}
