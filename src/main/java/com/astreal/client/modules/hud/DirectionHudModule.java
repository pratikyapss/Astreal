package com.astreal.client.modules.hud;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;

public class DirectionHudModule extends Module {
    public DirectionHudModule() {
        super("DirectionHUD", "Compass-style N/S/E/W direction indicator");
    }

    @Override
    public void onEnable() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;
            float yaw = MathHelper.wrapDegrees(client.player.getYaw());
            String dir = yaw < -135 || yaw > 135 ? "N" : yaw < -45 ? "E" : yaw < 45 ? "S" : "W";
            int degrees = Math.round(Math.abs(yaw));
            String label = dir + " " + degrees + "°";
            int x = client.getWindow().getScaledWidth() / 2 - client.textRenderer.getWidth(label) / 2;
            drawContext.drawText(client.textRenderer, label, x, 4, 0xFFFFFFFF, true);
        });
    }

    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}