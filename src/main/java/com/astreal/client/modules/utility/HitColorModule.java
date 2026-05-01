package com.astreal.client.modules.utility;

import com.astreal.client.modules.Module;

/**
 * HitColor — changes the entity red-flash color when hit.
 * Applied via HitColorMixin on EntityRenderer.renderEntity().
 */
public class HitColorModule extends Module {
    private int hitColor = 0xFFFF4444;

    public HitColorModule() {
        super("HitColor", "Custom RGB hit flash color on entities");
    }

    public void setHitColor(int argb) { this.hitColor = argb; }
    public int  getHitColor()         { return hitColor; }

    @Override public void onEnable()  {}
    @Override public void onUpdate()  {}
    @Override public void onDisable() {}
}