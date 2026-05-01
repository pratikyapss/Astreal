package com.astreal.client.modules.render;

import com.astreal.client.modules.Module;

public class MotionBlurModule extends Module {
    private float blurStrength = 0.5f; // 0.0 - 1.0

    public MotionBlurModule() {
        super("MotionBlur", "Screen-space motion blur during fast movement");
    }

    public float getBlurStrength() { return blurStrength; }
    public void setBlurStrength(float v) { this.blurStrength = Math.max(0f, Math.min(1f, v)); }

    @Override public void onEnable() {}
    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}