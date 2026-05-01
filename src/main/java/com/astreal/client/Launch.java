package com.astreal.client;

import net.minecraft.client.main.Main;

/**
 * Launch — main entry point for the Astreal Client JAR.
 * Launchers call this class via Main-Class in MANIFEST.MF.
 * Initializes client modules before handing off to Minecraft.
 */
public class Launch {
    public static void main(String[] args) {
        System.out.println("[AstrealClient] Initializing client...");
        // Pre-launch: client modules are initialized in AstrealClient.onInitializeClient()
        // which Fabric Loader calls automatically after Minecraft starts.
        Main.main(args);
    }
}
