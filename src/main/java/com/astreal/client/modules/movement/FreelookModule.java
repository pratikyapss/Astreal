package com.astreal.client.modules.movement;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class FreelookModule extends Module {
    private float savedYaw   = 0f;
    private float savedPitch = 0f;
    private boolean active   = false;

    public FreelookModule() {
        super("Freelook", "Look around without rotating the player model");
    }

    @Override
    public void onEnable() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> onUpdate());
    }

    @Override
    public void onUpdate() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (!isEnabled() || client.player == null) return;
        if (!active) {
            savedYaw   = client.player.getYaw();
            savedPitch = client.player.getPitch();
            active = true;
        }
    }

    @Override
    public void onDisable() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            client.player.setYaw(savedYaw);
            client.player.setPitch(savedPitch);
        }
        active = false;
    }
}
