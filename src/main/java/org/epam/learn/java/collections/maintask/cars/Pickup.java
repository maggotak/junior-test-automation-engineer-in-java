package org.epam.learn.java.collections.maintask.cars;

import org.epam.learn.java.collections.maintask.types.TypesOfPassengerCars;

import java.util.Objects;

public class Pickup extends Car {
    private int liftingCapacity;

    public Pickup(String model, long cost, double fuelConsumption, int maxSpeed, int liftingCapacity) {
        super(model, cost, fuelConsumption, maxSpeed);
        this.liftingCapacity = liftingCapacity;
    }

    public static Car createCar(String line) {
        String[] parameters = line.split(" ");
        return new Pickup(parameters[1], Long.parseLong(parameters[2]),
                Double.parseDouble(parameters[3]), Integer.parseInt(parameters[4]), Integer.parseInt(parameters[5]));
    }

    public int getLiftingCapacity() {
        return liftingCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pickup pickup = (Pickup) o;
        return liftingCapacity == pickup.liftingCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), liftingCapacity);
    }

    @Override
    public String toString() {
        return "Truck{" + super.toString() +
                "liftingCapacity=" + liftingCapacity +
                '}';
    }
}
