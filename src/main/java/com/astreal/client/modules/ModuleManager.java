package com.astreal.client.modules;

import com.astreal.client.modules.render.FullbrightModule;
import com.astreal.client.modules.movement.ZoomModule;
import com.astreal.client.modules.hud.FpsDisplayModule;
import com.astreal.client.modules.movement.ToggleSprintModule;
import com.astreal.client.modules.hud.KeystrokesHudModule;
import com.astreal.client.modules.hud.CpsCounterModule;
import com.astreal.client.modules.hud.ArmorStatusModule;
import com.astreal.client.modules.hud.ScoreboardTweaksModule;
import com.astreal.client.modules.hud.DirectionHudModule;
import com.astreal.client.modules.hud.PotionEffectsHudModule;
import com.astreal.client.modules.hud.ItemCooldownModule;
import com.astreal.client.modules.render.CrosshairModule;
import com.astreal.client.modules.render.HitboxOverlayModule;
import com.astreal.client.modules.render.ChunkBordersModule;
import com.astreal.client.modules.movement.FreelookModule;
import com.astreal.client.modules.render.MotionBlurModule;
import com.astreal.client.modules.render.NoHurtcamModule;
import com.astreal.client.modules.cosmetic.CapeSupportModule;
import com.astreal.client.modules.cosmetic.WingsModule;
import com.astreal.client.modules.cosmetic.HatCosmeticsModule;
import com.astreal.client.modules.cosmetic.ParticleTrailModule;
import com.astreal.client.modules.cosmetic.AnimatedCapeModule;
import com.astreal.client.modules.cosmetic.SkinEffectsModule;
import com.astreal.client.modules.utility.WaypointsModule;
import com.astreal.client.modules.utility.MinimapModule;
import com.astreal.client.modules.utility.AutoSprintModule;
import com.astreal.client.modules.utility.HitColorModule;
import com.astreal.client.modules.utility.BlockOverlayModule;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public void init() {
        modules.add(new FullbrightModule());
        modules.add(new ZoomModule());
        modules.add(new FpsDisplayModule());
        modules.add(new ToggleSprintModule());
        modules.add(new KeystrokesHudModule());
        modules.add(new CpsCounterModule());
        modules.add(new ArmorStatusModule());
        modules.add(new ScoreboardTweaksModule());
        modules.add(new DirectionHudModule());
        modules.add(new PotionEffectsHudModule());
        modules.add(new ItemCooldownModule());
        modules.add(new CrosshairModule());
        modules.add(new HitboxOverlayModule());
        modules.add(new ChunkBordersModule());
        modules.add(new FreelookModule());
        modules.add(new MotionBlurModule());
        modules.add(new NoHurtcamModule());
        modules.add(new CapeSupportModule());
        modules.add(new WingsModule());
        modules.add(new HatCosmeticsModule());
        modules.add(new ParticleTrailModule());
        modules.add(new AnimatedCapeModule());
        modules.add(new SkinEffectsModule());
        modules.add(new WaypointsModule());
        modules.add(new MinimapModule());
        modules.add(new AutoSprintModule());
        modules.add(new HitColorModule());
        modules.add(new BlockOverlayModule());
    }

    public List<Module> getModules() { return modules; }

    public Module getModule(String name) {
        return modules.stream()
            .filter(m -> m.getName().equals(name))
            .findFirst()
            .orElse(null);
    }

    public void toggleModule(String name) {
        Module m = getModule(name);
        if (m != null) m.toggle();
    }
          }
