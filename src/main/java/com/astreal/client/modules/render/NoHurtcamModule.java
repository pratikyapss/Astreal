package com.astreal.client.modules.render;

import com.astreal.client.modules.Module;

/**
 * NoHurtcam — cancels the camera tilt animation when the player takes damage.
 * Implemented via NoHurtcamMixin injecting into GameRenderer.tiltViewWhenHurt().
 */
public class NoHurtcamModule extends Module {
    public NoHurtcamModule() {
        super("NoHurtcam", "Disables camera shake when taking damage");
    }

    @Override public void onEnable() {}
    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}