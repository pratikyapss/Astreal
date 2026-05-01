package com.astreal.client.modules.cosmetic;

import com.astreal.client.modules.Module;

public class CapeSupportModule extends Module {
    private String capeUrl = "";

    public CapeSupportModule() {
        super("CapeSupport", "Renders a custom cosmetic cape via URL");
    }

    public void setCapeUrl(String url) { this.capeUrl = url; }
    public String getCapeUrl()         { return capeUrl; }

    @Override public void onEnable()  {}
    @Override public void onUpdate()  {}
    @Override public void onDisable() {}
}
