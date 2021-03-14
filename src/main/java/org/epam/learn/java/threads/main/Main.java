package org.epam.learn.java.threads.main;

import org.epam.learn.java.threads.main.entity.Direction;
import org.epam.learn.java.threads.main.entity.Train;
import org.epam.learn.java.threads.main.entity.Tunnel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Tunnel> tunnelForward = new ArrayBlockingQueue<>(1);
        BlockingQueue<Tunnel> tunnelBack = new ArrayBlockingQueue<>(1);
        try {
            tunnelForward.put(new Tunnel(Direction.FORWARD));
            tunnelBack.put(new Tunnel(Direction.BACK));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TunnelDispatcher pool = new TunnelDispatcher(tunnelForward, tunnelBack);

        for (int i = 0; i < 10; i++) {
            new Train(pool, Direction.getRandomDirection()).start();
        }
    }
}
