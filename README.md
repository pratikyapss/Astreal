# Astreal Client

Custom Minecraft client built with Astreal AI.

**Minecraft Version:** 1.21.11
**Features:** Fullbright, Zoom, FPS Display, Toggle Sprint, Keystrokes HUD, CPS Counter, Armor Status, Scoreboard Tweaks, Direction HUD, Potion Effects HUD, Item Cooldown, Crosshair Customizer, Hitbox Overlay, Chunk Borders, Freelook, Motion Blur, No Hurtcam, Cape Support, Wings, Hat Cosmetics, Particle Trail, Animated Cape, Skin Effects, Waypoints, Minimap, Auto Sprint, Hit Color, Block Overlay

## Building

```bash
./gradlew build
```

Output: `build/libs/astreal-client-1.0.0.jar`

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/installer/) for Minecraft 1.21.11.
2. Install [Fabric API](https://modrinth.com/mod/fabric-api).
3. Drop `astreal-client-1.0.0.jar` into your `mods/` folder.
4. Launch Minecraft — the client modules will initialize automatically.

## Module Architecture

Each feature is a self-contained `Module` subclass. Toggle modules at runtime:
```java
AstrealClient.moduleManager.toggleModule("Zoom");
```

## Launch Entry Point

The JAR entry point is `com.astreal.client.Launch` (via `Main-Class` in MANIFEST.MF).
This ensures launchers like MultiMC, Prism Launcher, and the official launcher
can locate the main class and start without "Failed to start the main class" errors.

## Source Layout

```
src/main/java/com/astreal/client/
├── Launch.java                 — Main-Class entry point (fixes launcher errors)
├── AstrealClient.java          — ClientModInitializer (Fabric entry point)
├── modules/
│   ├── Module.java             — Abstract base class
│   ├── ModuleManager.java      — Registry + toggle API
│   ├── movement/               — Zoom, ToggleSprint, Freelook
│   ├── render/                 — Fullbright, Hitbox, Crosshair, MotionBlur, NoHurtcam
│   ├── hud/                    — FPSDisplay, CPSCounter, KeystrokesHUD, etc.
│   ├── cosmetic/               — Wings, HatCosmetics, ParticleTrail, AnimatedCape, SkinEffects
│   └── utility/                — Waypoints, Minimap, AutoSprint, HitColor, BlockOverlay
└── mixin/
    ├── ZoomMixin.java          — FOV hook for Zoom module
    └── NoHurtcamMixin.java     — Camera tilt cancellation
```
