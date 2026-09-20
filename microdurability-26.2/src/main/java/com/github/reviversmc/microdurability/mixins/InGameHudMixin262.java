package com.github.reviversmc.microdurability.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;

import com.github.reviversmc.microdurability.MicroDurability;

@Mixin(Hud.class)
public class InGameHudMixin262 {
	@Shadow
	private int tickCount;

	@Inject(method = "extractHotbarAndDecorations", at = @At("RETURN"))
	private void renderArmorArea(GuiGraphicsExtractor context, DeltaTracker tickCounter, CallbackInfo callbackInfo) {
		if (!isTweakerooFreeCameraActive()) {
			MicroDurability.renderer.renderArmorArea(context, tickCount);
		}
	}

	@Inject(method = "extractCrosshair", at = @At("RETURN"))
	private void renderHeldItemExclamationMark(GuiGraphicsExtractor context, DeltaTracker tickCounter, CallbackInfo callbackInfo) {
		if (!isTweakerooFreeCameraActive()) {
			MicroDurability.renderer.renderHeldItemLowDurabilityWarning(context, tickCount);
		}
	}

	@Unique
	private static boolean isTweakerooFreeCameraActive() {
		try {
			Class<?> featureToggle = Class.forName("fi.dy.masa.tweakeroo.config.FeatureToggle");
			Object tweakFreeCamera = featureToggle.getField("TWEAK_FREE_CAMERA").get(null);
			return (boolean) tweakFreeCamera.getClass().getMethod("getBooleanValue").invoke(tweakFreeCamera);
		} catch (Exception e) {
			return false;
		}
	}
}
