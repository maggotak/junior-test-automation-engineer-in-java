package org.epam.learn.java.threads.main.entity;

import java.util.concurrent.TimeUnit;

public class Tunnel {
    private final Direction direction;
    private volatile boolean busy;

    public Tunnel(Direction direction, boolean busy) {
        this.direction = direction;
        this.busy = busy;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isBusy() {
        return busy;
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

    @Override
    public String toString() {
        return "Tunnel-" + direction;
    }
}
