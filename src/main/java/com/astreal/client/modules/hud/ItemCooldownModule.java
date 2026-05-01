package com.astreal.client.modules.hud;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;

public class ItemCooldownModule extends Module {
    public ItemCooldownModule() {
        super("ItemCooldownDisplay", "Visual cooldown bars for items near hotbar");
    }

    @Override
    public void onEnable() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;
            ItemStack held = client.player.getMainHandStack();
            if (held.isEmpty()) return;
            float cooldown = client.player.getItemCooldownManager()
                .getCooldownProgress(held.getItem(), tickDelta);
            if (cooldown > 0f) {
                int cx = client.getWindow().getScaledWidth() / 2;
                int cy = client.getWindow().getScaledHeight() - 30;
                int barW = (int) (40 * (1f - cooldown));
                drawContext.fill(cx - 20, cy, cx + 20, cy + 3, 0x80FFFFFF);
                drawContext.fill(cx - 20, cy, cx - 20 + barW, cy + 3, 0xFFFFAA00);
            }
        });
    }

    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}