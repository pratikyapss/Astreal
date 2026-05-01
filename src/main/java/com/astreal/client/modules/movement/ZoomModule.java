package com.astreal.client.modules.movement;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class ZoomModule extends Module {
    private static final double ZOOM_FOV = 30.0;
    private boolean zooming = false;

    public ZoomModule() {
        super("Zoom", "Zooms in like OptiFine");
    }

    @Override
    public void onEnable() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> onUpdate());
    }

    @Override
    public void onUpdate() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.options != null) {
            // FOV adjustment is handled via ZoomMixin
        }
    }

    @Override
    public void onDisable() {}

    public boolean isZooming() { return zooming; }
    public void setZooming(boolean zooming) { this.zooming = zooming; }
    public double getZoomFov() { return ZOOM_FOV; }
}