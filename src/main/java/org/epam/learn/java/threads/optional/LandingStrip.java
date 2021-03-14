package org.epam.learn.java.threads.optional;

import java.util.concurrent.TimeUnit;

public class LandingStrip {
    private final int id;

    public LandingStrip(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void using() {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
