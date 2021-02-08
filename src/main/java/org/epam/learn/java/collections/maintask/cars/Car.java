package org.epam.learn.java.collections.maintask.cars;

import java.util.Objects;

public class Car {
    private final String model;
    private final long cost;
    private final double fuelConsumption;
    private final int maxSpeed;

    public Car(String model, long cost, double fuelConsumption, int maxSpeed) {
        this.model = model;
        this.cost = cost;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public long getCost() {
        return cost;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return  "model='" + model + '\'' +
                ", cost=" + cost +
                ", fuelConsumption=" + fuelConsumption +
                ", maxSpeed=" + maxSpeed +
                ", ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return cost == car.cost && Double.compare(car.fuelConsumption, fuelConsumption) == 0
                && maxSpeed == car.maxSpeed && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, cost, fuelConsumption, maxSpeed);
    }
}
