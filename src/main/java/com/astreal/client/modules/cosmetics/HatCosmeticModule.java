package com.astreal.client.modules.cosmetic;

import com.astreal.client.modules.Module;

public class HatCosmeticsModule extends Module {
    public enum HatType { CROWN, WIZARD, SANTA, TOPHAT, HALO }

    private HatType hatType = HatType.CROWN;

    public HatCosmeticsModule() {
        super("HatCosmetics", "3D hat models rendered above the player head");
    }

    public void setHatType(HatType type) { this.hatType = type; }
    public HatType getHatType()          { return hatType; }

    @Override public void onEnable()  {}
    @Override public void onUpdate()  {}
    @Override public void onDisable() {}
}
