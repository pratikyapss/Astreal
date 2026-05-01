package com.astreal.client.mixin;

import com.astreal.client.AstrealClient;
import com.astreal.client.modules.render.NoHurtcamModule;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class NoHurtcamMixin {
    @Inject(at = @At("HEAD"), method = "tiltViewWhenHurt", cancellable = true)
    private void onTiltView(float tickDelta, CallbackInfo ci) {
        if (AstrealClient.moduleManager != null) {
            NoHurtcamModule nhc = (NoHurtcamModule) AstrealClient.moduleManager.getModule("NoHurtcam");
            if (nhc != null && nhc.isEnabled()) ci.cancel();
        }
    }
}
