package org.epam.learn.java.collections.maintask;

import org.epam.learn.java.collections.maintask.cars.Car;
import java.util.List;

public class MainTaxi {
    public static void main(String[] args) {
        List<Car> carList = TaxiStation.createTaxiStation();
        TaxiStation taxiStation = new TaxiStation(carList);
        List<Car> sortedCarsByFuelConsumption = taxiStation.sortByFuelConsumption();
        long costOfTaxiStation = taxiStation.getCostOfTaxiStation();

        int minSpeed = 120;
        int maxSpeed = 150;
        List<Car> carListBySpeedRange = taxiStation.carsInSpeedRange(minSpeed, maxSpeed);

        System.out.println("Sorted cars by fuel consumption:\n" + sortedCarsByFuelConsumption);
        System.out.println("Cost of taxi station = " + costOfTaxiStation);
        System.out.println("Car list by speed range with minimum = " + minSpeed + " , maximum = " + maxSpeed + "\n" + carListBySpeedRange);
    }
}
