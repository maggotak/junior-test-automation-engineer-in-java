package org.epam.learn.java.collections.maintask.cars;

import org.epam.learn.java.collections.maintask.types.TypesOfPassengerCars;

import java.util.Objects;

public class PassengerCar extends Car {
    private TypesOfPassengerCars type;

    public PassengerCar(String model, long cost, double fuelConsumption, int maxSpeed, TypesOfPassengerCars type) {
        super(model, cost, fuelConsumption, maxSpeed);
        this.type = type;
    }

    public static Car createCar(String line) {
        String[] parameters = line.split(" ");
        TypesOfPassengerCars type = TypesOfPassengerCars.valueOf(parameters[5]);
        return new PassengerCar(parameters[1], Long.parseLong(parameters[2]),
                Double.parseDouble(parameters[3]), Integer.parseInt(parameters[4]), type);
    }

    public TypesOfPassengerCars getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerCar that = (PassengerCar) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "PassengerCar{" + super.toString() +
                "type=" + type +
                '}';
    }
}
