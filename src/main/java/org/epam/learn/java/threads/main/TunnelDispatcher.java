package org.epam.learn.java.threads.main;

import org.epam.learn.java.threads.main.entity.Direction;
import org.epam.learn.java.threads.main.entity.Train;
import org.epam.learn.java.threads.main.entity.Tunnel;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TunnelDispatcher {
    private final static int POOL_SIZE = 2;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final List<Tunnel> tunnels;

    public TunnelDispatcher(List<Tunnel> tunnels) {
        this.tunnels = tunnels;
    }

    public Tunnel dispatch(Train train) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Direction trainDirection = train.getDirection();
        Tunnel trainTunnel = null;
        Tunnel notTrainTunnel = null;

        for (Tunnel tunnel : tunnels) {
            if (trainDirection == tunnel.getDirection()) {
                trainTunnel = tunnel;
            } else {
                notTrainTunnel = tunnel;
            }
        }

        if (trainTunnel.isBusy()) {
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (trainTunnel.isBusy() && !notTrainTunnel.isBusy()) {
            notTrainTunnel.setBusy(true);
            return notTrainTunnel;
        } else {
            trainTunnel.setBusy(true);
            return trainTunnel;
        }
    }

    public void passed(Train train, Tunnel tunnel) {
        tunnel.setBusy(false);
        System.out.println("Train " + train.getId() + "-" + train.getDirection() + " passed throw "
                + tunnel + " at " + LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        semaphore.release();
    }
}
