package com.astreal.client.modules.utility;

import com.astreal.client.modules.Module;
import net.minecraft.util.math.BlockPos;
import java.util.ArrayList;
import java.util.List;

public class WaypointsModule extends Module {
    public record Waypoint(String name, BlockPos pos, int color) {}

    private final List<Waypoint> waypoints = new ArrayList<>();

    public WaypointsModule() {
        super("Waypoints", "Named position markers with in-world arrows");
    }

    public void addWaypoint(String name, BlockPos pos, int color) {
        waypoints.add(new Waypoint(name, pos, color));
    }

    public void removeWaypoint(String name) {
        waypoints.removeIf(w -> w.name().equals(name));
    }

    public List<Waypoint> getWaypoints() { return List.copyOf(waypoints); }

    @Override public void onEnable() {}
    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}