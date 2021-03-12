package org.epam.learn.java.threads.main;

import org.epam.learn.java.threads.main.entity.Direction;
import org.epam.learn.java.threads.main.entity.Train;
import org.epam.learn.java.threads.main.entity.Tunnel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Tunnel> tunnels = new ArrayList<>();
        tunnels.add(new Tunnel(Direction.FORWARD, false));
        tunnels.add(new Tunnel(Direction.BACK, false));

        TunnelDispatcher pool = new TunnelDispatcher(tunnels);

        for (int i = 0; i < 10; i++) {
            new Train(pool, Direction.getRandomDirection()).start();
        }
    }
}
