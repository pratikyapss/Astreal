package com.astreal.client.modules.hud;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class KeystrokesHudModule extends Module {
    public KeystrokesHudModule() {
        super("KeystrokesHUD", "Shows WASD and mouse keys on screen");
    }

    @Override
    public void onEnable() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;
            boolean w = client.options.forwardKey.isPressed();
            boolean a = client.options.leftKey.isPressed();
            boolean s = client.options.backKey.isPressed();
            boolean d = client.options.rightKey.isPressed();
            int x = client.getWindow().getScaledWidth() / 2 - 30;
            int y = client.getWindow().getScaledHeight() - 60;
            int activeColor = 0xFFFFFFFF, inactiveColor = 0x80FFFFFF;
            drawContext.drawText(client.textRenderer, "W", x + 14, y,      w ? activeColor : inactiveColor, true);
            drawContext.drawText(client.textRenderer, "A", x,      y + 10, a ? activeColor : inactiveColor, true);
            drawContext.drawText(client.textRenderer, "S", x + 14, y + 10, s ? activeColor : inactiveColor, true);
            drawContext.drawText(client.textRenderer, "D", x + 28, y + 10, d ? activeColor : inactiveColor, true);
        });
    }

    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}