package org.epam.learn.java.threads.main;

import org.epam.learn.java.threads.main.entity.Direction;
import org.epam.learn.java.threads.main.entity.Train;
import org.epam.learn.java.threads.main.entity.Tunnel;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TunnelDispatcher {
    private final BlockingQueue<Tunnel> tunnelForward;
    private final BlockingQueue<Tunnel> tunnelBack;

    public TunnelDispatcher(BlockingQueue<Tunnel> tunnelForward, BlockingQueue<Tunnel> tunnelBack) {
        this.tunnelForward = tunnelForward;
        this.tunnelBack = tunnelBack;
    }

    public void dispatch(Train train) {
        while (!usingTunnel(train, train.getDirection() == Direction.FORWARD ? tunnelForward : tunnelBack)) {
            if (tunnelBack.size() != 0) {
                usingTunnel(train, tunnelBack);
            }
            if (tunnelForward.size() != 0) {
                usingTunnel(train, tunnelForward);
            }
        }
    }

    private boolean usingTunnel(Train train, BlockingQueue<Tunnel> tunnels) {
        try {
            Tunnel tunnel = tunnels.poll(3000, TimeUnit.MILLISECONDS);
            if (tunnel != null) {
                tunnel.using();
                System.out.println("Train " + train.getId() + "-" + train.getDirection() + " passed throw "
                        + tunnel + " at " + LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
                tunnels.put(tunnel);
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
