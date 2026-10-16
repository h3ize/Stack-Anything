package com.stackanything;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(StackAnythingMod.MOD_ID)
public class StackAnythingMod {
    public static final String MOD_ID = "stackanything";

    public StackAnythingMod(ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
