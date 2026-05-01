package com.astreal.client.modules;

public abstract class Module {
    private final String  name;
    private final String  description;
    private       boolean enabled;

    protected Module(String name, String description) {
        this.name        = name;
        this.description = description;
        this.enabled     = false;
    }

    public void enable()  { this.enabled = true;  onEnable();  }
    public void disable() { this.enabled = false; onDisable(); }
    public void toggle()  { if (enabled) disable(); else enable(); }

    public abstract void onEnable();
    public abstract void onUpdate();
    public abstract void onDisable();

    public String  getName()        { return name;        }
    public String  getDescription() { return description; }
    public boolean isEnabled()      { return enabled;     }
}
