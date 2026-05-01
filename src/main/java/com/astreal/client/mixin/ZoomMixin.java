package com.astreal.client.mixin;

import com.astreal.client.AstrealClient;
import com.astreal.client.modules.movement.ZoomModule;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class ZoomMixin {
    @Inject(at = @At("RETURN"), method = "getFov", cancellable = true)
    private void onGetFov(CallbackInfoReturnable<Double> cir) {
        if (AstrealClient.moduleManager != null) {
            ZoomModule zoom = (ZoomModule) AstrealClient.moduleManager.getModule("Zoom");
            if (zoom != null && zoom.isEnabled() && zoom.isZooming()) {
                cir.setReturnValue(zoom.getZoomFov());
            }
        }
    }
}
