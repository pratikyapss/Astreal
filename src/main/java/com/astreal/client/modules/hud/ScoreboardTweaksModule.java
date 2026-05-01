package com.astreal.client.modules.hud;

import com.astreal.client.modules.Module;

public class ScoreboardTweaksModule extends Module {
    private int backgroundOpacity = 80;
    private boolean hideScores = true;

    public ScoreboardTweaksModule() {
        super("ScoreboardTweaks", "Compact, stylized scoreboard with custom colors");
    }

    public void setBackgroundOpacity(int opacity) { this.backgroundOpacity = opacity; }
    public void setHideScores(boolean hide) { this.hideScores = hide; }
    public int getBackgroundOpacity() { return backgroundOpacity; }
    public boolean isHideScores() { return hideScores; }

    @Override public void onEnable() {}
    @Override public void onUpdate() {}
    @Override public void onDisable() {}
}