package com.astreal.client.modules.movement;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class ToggleSprintModule extends Module {
    public ToggleSprintModule() {
        super("ToggleSprint", "Automatically sprints when moving");
    }

    @Override
    public void onEnable() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> onUpdate());
    }

    @Override
    public void onUpdate() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (isEnabled() && client.player != null) {
            client.player.setSprinting(true);
        }
    }

    @Override
    public void onDisable() {}
}