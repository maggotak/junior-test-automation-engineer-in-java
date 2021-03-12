package org.epam.learn.java.threads.optional;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LandingStrip> list = new ArrayList<>();
        list.add(new LandingStrip(false, 1));
        list.add(new LandingStrip(false, 2));
        list.add(new LandingStrip(false, 3));
        list.add(new LandingStrip(false, 4));
        list.add(new LandingStrip(false, 5));

        LandingStripPool pool = new LandingStripPool(list);
        for (int i = 0; i < 10; i++) {
            new Plane(pool).start();
        }
    }
}
