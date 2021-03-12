package org.epam.learn.java.threads.optional;

import java.util.List;
import java.util.concurrent.Semaphore;

public class LandingStripPool {
    private final static int POOL_SIZE = 5;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final List<LandingStrip> landingStrips;

    public LandingStripPool(List<LandingStrip> landingStrips) {
        this.landingStrips = landingStrips;
    }

    public LandingStrip dispatch(Plane plane) throws ResourceException {
        try {
            semaphore.acquire();
            for (LandingStrip strip : landingStrips) {
                if (!strip.isBusy()) {
                    strip.setBusy(true);
                    System.out.println("Plane " + plane.getId()
                            + " starting at strip №" + strip.getId());
                    return strip;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new ResourceException("Something wrong - all strips are busy");
    }

    public void fly(Plane plane, LandingStrip strip) {
        strip.setBusy(false);
        System.out.println("Plane " + plane.getId() + " fly. Strip №"
                + strip.getId() + " is free");
        semaphore.release();
    }
}
