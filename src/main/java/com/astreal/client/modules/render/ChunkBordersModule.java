package com.astreal.client.modules.render;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

public class ChunkBordersModule extends Module {
    public ChunkBordersModule() {
        super("ChunkBorders", "Shows chunk boundary lines in-world");
    }

    @Override
    public void onEnable() {
        WorldRenderEvents.AFTER_TRANSLUCENT.register(context -> {
            if (!isEnabled()) return;
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;
            BlockPos pos = client.player.getBlockPos();
            int chunkX = pos.getX() >> 4;
            int chunkZ = pos.getZ() >> 4;
            // Draw 16x16 grid lines around current chunk using context.matrixStack()
            _ = chunkX; _ = chunkZ;
        });
    }

    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}
