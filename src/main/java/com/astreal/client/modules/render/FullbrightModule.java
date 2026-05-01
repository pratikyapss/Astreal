package com.astreal.client.modules.render;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class FullbrightModule extends Module {
    private static final float GAMMA = 16.0f;

    public FullbrightModule() {
        super("Fullbright", "Makes everything fully lit");
    }

    @Override
    public void onEnable() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> onUpdate());
    }

    @Override
    public void onUpdate() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (isEnabled() && client.options != null) {
            client.options.getGamma().setValue((double) GAMMA);
        }
    }

    @Override
    public void onDisable() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.options != null) {
            client.options.getGamma().setValue(1.0);
        }
    }
}