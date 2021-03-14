package org.epam.learn.java.threads.optional;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<LandingStrip> queue = new ArrayBlockingQueue<>(5);
        try {
            queue.put(new LandingStrip(1));
            queue.put(new LandingStrip(2));
            queue.put(new LandingStrip(3));
            queue.put(new LandingStrip(4));
            queue.put(new LandingStrip(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
           new Plane(queue).start();
        }
    }
}
