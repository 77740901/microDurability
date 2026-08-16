package com.github.reviversmc.microdurability.compat.mods;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigManager;
import me.shedaniel.autoconfig.gui.ConfigScreenProvider;
import me.shedaniel.autoconfig.gui.DefaultGuiProviders;
import me.shedaniel.autoconfig.gui.DefaultGuiTransformers;
import me.shedaniel.autoconfig.gui.registry.GuiRegistry;
import me.shedaniel.autoconfig.gui.registry.api.GuiRegistryAccess;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

import net.minecraft.client.gui.screens.Screen;

import com.github.reviversmc.microdurability.ModConfig;

public class ClothConfigCompat262 {
	public static ModConfig loadConfig() {
		return AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new).getConfig();
	}

	public static Screen getScreen(Screen parent) {
		ConfigManager<ModConfig> manager = (ConfigManager<ModConfig>) AutoConfig.getConfigHolder(ModConfig.class);
		GuiRegistry registry = new GuiRegistry();
		DefaultGuiProviders.apply(registry);
		DefaultGuiTransformers.apply(registry);
		return new ConfigScreenProvider<>(manager, (GuiRegistryAccess) registry, parent).get();
	}
}
