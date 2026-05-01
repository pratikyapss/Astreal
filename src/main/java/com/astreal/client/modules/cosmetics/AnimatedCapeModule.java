package com.astreal.client.modules.cosmetic;

import com.astreal.client.modules.Module;

public class AnimatedCapeModule extends Module {
    public enum CapeStyle { WAVE, RAINBOW, STATIC }

    private CapeStyle capeStyle = CapeStyle.WAVE;
    private float animationSpeed = 1.0f;
    private int animTick = 0;

    public AnimatedCapeModule() {
        super("AnimatedCape", "Cape with animated texture — wave, rainbow, or static");
    }

    public void setCapeStyle(CapeStyle style) { this.capeStyle = style; }
    public void setAnimationSpeed(float s)    { this.animationSpeed = s; }
    public CapeStyle getCapeStyle()           { return capeStyle; }
    public float getAnimOffset()              { return animTick * 0.05f * animationSpeed; }

    @Override
    public void onEnable() {}

    @Override
    public void onUpdate() {
        if (isEnabled()) animTick++;
    }

    @Override
    public void onDisable() { animTick = 0; }
}
