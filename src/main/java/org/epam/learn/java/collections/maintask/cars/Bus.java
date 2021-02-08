package org.epam.learn.java.collections.maintask.cars;

import java.util.Objects;

public class Bus extends Car {
    private final int passengersCapacity;

    public Bus(String model, long cost, double fuelConsumption, int maxSpeed, int passengersCapacity) {
        super(model, cost, fuelConsumption, maxSpeed);
        this.passengersCapacity = passengersCapacity;
    }

    public static Car createCar(String line) {
        String[] parameters = line.split(" ");
        return new Bus(parameters[1], Long.parseLong(parameters[2]),
                Double.parseDouble(parameters[3]), Integer.parseInt(parameters[4]), Integer.parseInt(parameters[5]));
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return passengersCapacity == bus.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() +
                "passengersCapacity=" + passengersCapacity +
                '}';
    }
}
