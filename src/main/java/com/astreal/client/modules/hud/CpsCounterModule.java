package com.astreal.client.modules.hud;

import com.astreal.client.modules.Module;
import java.util.LinkedList;
import java.util.Queue;

public class CpsCounterModule extends Module {
    private final Queue<Long> leftClicks  = new LinkedList<>();
    private final Queue<Long> rightClicks = new LinkedList<>();

    public CpsCounterModule() {
        super("CPSCounter", "Tracks clicks per second");
    }

    public void recordLeftClick()  { leftClicks.offer(System.currentTimeMillis()); }
    public void recordRightClick() { rightClicks.offer(System.currentTimeMillis()); }

    public int getLeftCPS()  { return countRecent(leftClicks); }
    public int getRightCPS() { return countRecent(rightClicks); }

    private int countRecent(Queue<Long> queue) {
        long now = System.currentTimeMillis();
        queue.removeIf(t -> now - t > 1000L);
        return queue.size();
    }

    @Override public void onEnable() {}
    @Override public void onUpdate() {}
    @Override public void onDisable() { leftClicks.clear(); rightClicks.clear(); }
}