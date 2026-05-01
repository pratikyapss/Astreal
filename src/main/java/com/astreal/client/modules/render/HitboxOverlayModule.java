package com.astreal.client.modules.render;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;

public class HitboxOverlayModule extends Module {
    public HitboxOverlayModule() {
        super("HitboxOverlay", "Renders entity hitbox wireframes");
    }

    @Override
    public void onEnable() {
        WorldRenderEvents.AFTER_ENTITIES.register(context -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.world == null) return;
            for (Entity entity : client.world.getEntities()) {
                // Render bounding box wireframe via WorldRenderContext matrices
                // entity.getBoundingBox() provides the hitbox AABB
            }
        });
    }

    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}