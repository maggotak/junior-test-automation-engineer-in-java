package org.epam.learn.java.threads.main.entity;

import org.epam.learn.java.threads.main.TunnelDispatcher;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Train extends Thread {

    private final TunnelDispatcher pool;
    private final Direction direction;

    public Train (TunnelDispatcher pool, Direction direction) {
        this.pool = pool;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
            pool.dispatch(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
