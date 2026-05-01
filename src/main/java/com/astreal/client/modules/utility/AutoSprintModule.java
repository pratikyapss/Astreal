package com.astreal.client.modules.utility;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class AutoSprintModule extends Module {
    public enum SprintMode { ALWAYS, FORWARD_ONLY }
    private SprintMode mode = SprintMode.ALWAYS;

    public AutoSprintModule() {
        super("AutoSprint", "Automatically activates sprint without holding the key");
    }

    @Override
    public void onEnable() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> onUpdate());
    }

    @Override
    public void onUpdate() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (!isEnabled() || client.player == null) return;
        boolean moving = mode == SprintMode.ALWAYS ||
            client.options.forwardKey.isPressed();
        if (moving) client.player.setSprinting(true);
    }

    @Override
    public void onDisable() {}

    public void setMode(SprintMode mode) { this.mode = mode; }
    public SprintMode getMode() { return mode; }
}
