package org.epam.learn.java.threads.main.entity;

import java.util.Random;

public enum Direction {
    FORWARD("forward"), BACK("back");
    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public static Direction getRandomDirection() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    @Override
    public String toString() {
        return name;
    }
}
