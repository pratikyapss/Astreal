package com.astreal.client.modules.hud;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;

public class PotionEffectsHudModule extends Module {
    public PotionEffectsHudModule() {
        super("PotionEffectsHUD", "Shows active potion effects with timers");
    }

    @Override
    public void onEnable() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;
            int y = 40;
            for (StatusEffectInstance effect : client.player.getStatusEffects()) {
                int ticks = effect.getDuration();
                String time = ticks == Integer.MAX_VALUE ? "∞" : (ticks / 20) + "s";
                String name = effect.getEffectType().toString() + " " + time;
                drawContext.drawText(client.textRenderer, name, 2, y, 0xFFAA00FF, true);
                y += 10;
            }
        });
    }

    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}