package com.astreal.client.modules.hud;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class FpsDisplayModule extends Module {
    public FpsDisplayModule() {
        super("FPSDisplay", "Shows current FPS on screen");
    }

    @Override
    public void onEnable() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            int fps = client.getCurrentFps();
            drawContext.drawText(client.textRenderer, "FPS: " + fps, 2, 2, 0xFFFFFF, true);
        });
    }

    @Override
    public void onUpdate() {}

    @Override
    public void onDisable() {}
}