package org.epam.learn.java.threads.optional;


import java.util.concurrent.TimeUnit;

public class Plane extends Thread {
    private LandingStripPool pool;

    public Plane (LandingStripPool pool) {
        this.pool = pool;
    }


    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            LandingStrip landingStrip = pool.dispatch(this);
            landingStrip.using();
            pool.fly(this, landingStrip);
        } catch (InterruptedException | ResourceException e) {
            e.printStackTrace();
        }
    }
}
