package com.astreal.client.modules.cosmetic;

import com.astreal.client.modules.Module;

public class SkinEffectsModule extends Module {
    public enum EffectType { GLOW, SHADOW, OUTLINE, FIRE_AURA }

    private EffectType effectType = EffectType.GLOW;

    public SkinEffectsModule() {
        super("SkinEffects", "Visual glow/outline/aura overlaid on player skin");
    }

    public void setEffectType(EffectType type) { this.effectType = type; }
    public EffectType getEffectType()           { return effectType; }

    @Override public void onEnable()  {}
    @Override public void onUpdate()  {}
    @Override public void onDisable() {}
}
