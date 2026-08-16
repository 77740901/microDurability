package com.github.reviversmc.microdurability;

import java.util.List;

import com.github.reviversmc.microdurability.compat.minecraft.McVersionMixinProvider;

public class MixinProvider262 extends McVersionMixinProvider {
	@Override
	public List<String> getMixins() {
		if (MicroDurability262.IS_COMPATIBLE.get()) {
			return List.of("InGameHudMixin262");
		}

		return null;
	}
}
