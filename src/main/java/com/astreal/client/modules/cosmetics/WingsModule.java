package com.astreal.client.modules.cosmetic;

import com.astreal.client.modules.Module;

public class WingsModule extends Module {
    public enum WingType { ANGEL, DEMON, BUTTERFLY, DRAGON }

    private WingType wingType = WingType.ANGEL;
    private int      wingColor = 0xFFFFFFFF;
    private float    animationSpeed = 1.0f;
    private int      animTick = 0;

    public WingsModule() {
        super("Wings", "Animated wings rendered on player back");
    }

    public void setWingType(WingType type) { this.wingType = type; }
    public void setWingColor(int argb)     { this.wingColor = argb; }
    public void setAnimationSpeed(float s) { this.animationSpeed = s; }
    public WingType getWingType()          { return wingType; }
    public float    getAnimAngle()         { return (float) Math.sin(animTick * 0.05f * animationSpeed); }

    @Override
    public void onEnable() {}

    @Override
    public void onUpdate() {
        if (isEnabled()) animTick++;
    }

    @Override
    public void onDisable() { animTick = 0; }
}
