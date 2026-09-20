package com.github.reviversmc.microdurability;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;

public class Renderer262 extends Renderer {
	private static final int ICON_TEXTURE_SIZE = 256;

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
		((GuiGraphicsExtractor) context).blit(
				RenderPipelines.GUI_TEXTURED,
				(Identifier) texture,
				x, y,
				(float) u, (float) v,
				width, height,
				ICON_TEXTURE_SIZE, ICON_TEXTURE_SIZE);
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
		((GuiGraphicsExtractor) context).fill(x, y, x + width, y + height, color);
	}
}
