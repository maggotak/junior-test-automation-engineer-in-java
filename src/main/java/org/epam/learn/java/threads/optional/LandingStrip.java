package org.epam.learn.java.threads.optional;

import java.util.concurrent.TimeUnit;

public class LandingStrip {
    private final int id;
    private volatile boolean busy;

    public LandingStrip(boolean busy, int id) {
        this.busy = busy;
        this.id = id;
    }

    public boolean isBusy() {
        return busy;
    }

    public int getId() {
        return id;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void using() {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
