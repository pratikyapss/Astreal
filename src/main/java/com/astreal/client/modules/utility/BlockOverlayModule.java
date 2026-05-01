package com.astreal.client.modules.utility;

import com.astreal.client.modules.Module;

public class BlockOverlayModule extends Module {
    public enum OverlayStyle { OUTLINE, FILL, BOTH }

    private OverlayStyle style = OverlayStyle.OUTLINE;
    private int overlayColor = 0x80FFFFFF;

    public BlockOverlayModule() {
        super("BlockOverlay", "Custom block selection highlight color and style");
    }

    public void setStyle(OverlayStyle style)  { this.style = style; }
    public void setOverlayColor(int argb)     { this.overlayColor = argb; }
    public OverlayStyle getStyle()            { return style; }
    public int          getOverlayColor()     { return overlayColor; }

    @Override public void onEnable()  {}
    @Override public void onUpdate()  {}
    @Override public void onDisable() {}
}