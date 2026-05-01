package com.astreal.client.modules.cosmetic;

import com.astreal.client.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.particle.ParticleTypes;

public class ParticleTrailModule extends Module {
    public enum TrailType { HEARTS, STARS, FLAMES, SNOWFLAKES, RAINBOW }

    private TrailType trailType = TrailType.HEARTS;

    public ParticleTrailModule() {
        super("ParticleTrail", "Animated particle trail behind player movement");
    }

    public void setTrailType(TrailType type) { this.trailType = type; }
    public TrailType getTrailType()          { return trailType; }

    @Override
    public void onEnable() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> onUpdate());
    }

    @Override
    public void onUpdate() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (!isEnabled() || client.player == null || client.world == null) return;
        if (client.player.getVelocity().horizontalLengthSquared() < 0.001) return;
        // Spawn particles at player feet based on trailType
        var particleType = switch (trailType) {
            case FLAMES    -> ParticleTypes.FLAME;
            case SNOWFLAKES -> ParticleTypes.SNOWFLAKE;
            default        -> ParticleTypes.HEART;
        };
        double x = client.player.getX();
        double y = client.player.getY();
        double z = client.player.getZ();
        client.world.addParticle(particleType, x, y, z, 0, 0.1, 0);
    }

    @Override public void onDisable() {}
}
