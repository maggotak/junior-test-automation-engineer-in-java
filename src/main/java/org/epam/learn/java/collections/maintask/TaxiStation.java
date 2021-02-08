package org.epam.learn.java.collections.maintask;

import org.epam.learn.java.collections.maintask.cars.Bus;
import org.epam.learn.java.collections.maintask.cars.Car;
import org.epam.learn.java.collections.maintask.cars.PassengerCar;
import org.epam.learn.java.collections.maintask.cars.Pickup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiStation {
    private List<Car> carList;

    public TaxiStation(List<Car> carList) {
        this.carList = carList;
    }

    public static List<Car> createTaxiStation() {
        List<Car> carList = new ArrayList<>();
        String fileName = "src/main/resources/Cars.txt";
        String line;
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            line = bufferedReader.readLine();
            while (line != null) {
                if (line.toLowerCase().startsWith("passenger")) {
                    Car car = PassengerCar.createCar(line);
                    carList.add(car);
                } else if (line.toLowerCase().startsWith("bus")) {
                    Car car =  Bus.createCar(line);
                    carList.add(car);
                } else if (line.toLowerCase().startsWith("pickup")) {
                    Car car = Pickup.createCar(line);
                    carList.add(car);
                } else {
                    throw new IllegalArgumentException();
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public long getCostOfTaxiStation() {
        long cost = 0;
        for (Car car : carList) {
            cost += car.getCost();
        }
        return cost;
    }

    public List<Car> sortByFuelConsumption() {
        List<Car> sortedList = new ArrayList<>(carList);
        sortedList.sort(Comparator.comparing(Car::getFuelConsumption));
        return sortedList;
    }

    public List<Car> carsInSpeedRange(int minSpeed, int maxSpeed) {
        List<Car> carsInSpeedRangeList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed) {
                carsInSpeedRangeList.add(car);
            }
        }
        return carsInSpeedRangeList;
    }

}
