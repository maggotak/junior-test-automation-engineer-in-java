package org.epam.learn.java.threads.main.entity;

import java.util.concurrent.TimeUnit;

public class Tunnel {
    private final Direction direction;

    public Tunnel(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
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
