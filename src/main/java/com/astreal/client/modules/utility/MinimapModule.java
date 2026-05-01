package com.astreal.client.modules.utility;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class MinimapModule extends Module {
    private int mapSize = 128;

    public MinimapModule() {
        super("Minimap", "Overhead minimap rendered on the HUD");
    }

    public void setMapSize(int px) { this.mapSize = px; }

    @Override
    public void onEnable() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.world == null || client.player == null) return;
            int x = client.getWindow().getScaledWidth() - mapSize - 8;
            int y = 8;
            drawContext.fill(x, y, x + mapSize, y + mapSize, 0x80000000);
            // Render chunk texture map around player position via drawContext
        });
    }

    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}