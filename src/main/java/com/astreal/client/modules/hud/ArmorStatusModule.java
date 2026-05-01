package com.astreal.client.modules.hud;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;

public class ArmorStatusModule extends Module {
    public ArmorStatusModule() {
        super("ArmorStatus", "Displays armor durability on screen");
    }

    @Override
    public void onEnable() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;
            int y = 2;
            for (ItemStack stack : client.player.getArmorItems()) {
                if (!stack.isEmpty()) {
                    int dur = stack.getMaxDamage() - stack.getDamage();
                    int pct = (int) ((float) dur / stack.getMaxDamage() * 100);
                    int color = pct > 50 ? 0xFF00FF00 : pct > 20 ? 0xFFFFFF00 : 0xFFFF0000;
                    drawContext.drawText(client.textRenderer, stack.getItem().toString() + ": " + pct + "%", 2, y, color, true);
                    y += 10;
                }
            }
        });
    }

    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}
