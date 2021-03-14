package org.epam.learn.java.threads.optional;

import java.util.concurrent.BlockingQueue;

public class Plane extends Thread {
    private final BlockingQueue<LandingStrip> strips;

    public Plane (BlockingQueue<LandingStrip> strips) {
        this.strips = strips;
    }

    @Override
    public void run() {
        try {
            LandingStrip strip = strips.take();
            System.out.println("Landing strip #" + strip.getId() + " taking plane #" + this.getId());
            strip.using();
            System.out.println("Plane #" + this.getId() + " is took off");
            System.out.println("Landing strip #" + strip.getId() + " is free");
            strips.put(strip);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
