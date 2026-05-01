package com.astreal.client.modules.render;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class CrosshairModule extends Module {
    private int color     = 0xFF00FF00;
    private int size      = 6;
    private int gap       = 2;
    private int thickness = 2;

    public CrosshairModule() {
        super("CrosshairCustomizer", "Custom crosshair style and color");
    }

    public void setColor(int argb) { this.color = argb; }
    public void setSize(int px)    { this.size  = px;   }
    public void setGap(int px)     { this.gap   = px;   }

    @Override
    public void onEnable() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            int cx = client.getWindow().getScaledWidth()  / 2;
            int cy = client.getWindow().getScaledHeight() / 2;
            drawContext.fill(cx - size, cy - thickness / 2, cx - gap, cy + thickness / 2, color);
            drawContext.fill(cx + gap,  cy - thickness / 2, cx + size, cy + thickness / 2, color);
            drawContext.fill(cx - thickness / 2, cy - size, cx + thickness / 2, cy - gap, color);
            drawContext.fill(cx - thickness / 2, cy + gap,  cx + thickness / 2, cy + size, color);
        });
    }

    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}