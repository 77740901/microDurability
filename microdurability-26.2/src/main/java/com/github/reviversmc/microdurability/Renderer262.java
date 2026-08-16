package com.github.reviversmc.microdurability;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;

public class Renderer262 extends Renderer {
	@Override
	protected boolean hasMending(Object stackObj) {
		ItemStack stack = (ItemStack) stackObj;

		for (Holder<Enchantment> enchantment : stack.getEnchantments().keySet()) {
			if (!enchantment.value().getEffects(EnchantmentEffectComponents.REPAIR_WITH_XP).isEmpty()) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected int getItemBarStep(Object stack) {
		return ((ItemStack) stack).getBarWidth();
	}

	@Override
	protected int getItemBarColor(Object stack) {
		return ((ItemStack) stack).getBarColor();
	}

	@Override
	protected void drawWarningTexture(Object texture, Object context, int x, int y, int u, int v, int width, int height) {
		((GuiGraphicsExtractor) context).blit((Identifier) texture, x, y, width, height, (float) u, (float) v, (float) width, (float) height);
	}

	@Override
	protected void preRenderGuiQuads() {
	}

	@Override
	protected void postRenderGuiQuads() {
	}

	@Override
	protected void renderGuiQuad(Object context, int x, int y, int width, int height, int red, int green, int blue, int alpha) {
		int color = (alpha << 24) | (red << 16) | (green << 8) | blue;
		// GuiGraphicsExtractor.fill uses (x1, y1, x2, y2, color), not (x, y, width, height)
		((GuiGraphicsExtractor) context).fill(x, y, x + width, y + height, color);
	}
}
