package com.akruglov.chapter02;

/**
 * Created by kruglovs on 23.03.17.
 */
public class Car {

    private double rate;
    private double x;
    private double fuelCapacity;

    public Car(double rate) {
        this.rate = rate;
    }

    public void move(double distance) {
        double neededFuel = distance / rate;

        if (fuelCapacity >= neededFuel) {
            fuelCapacity -= neededFuel;
            x += distance;
        } else {
            x += (fuelCapacity * rate);
            fuelCapacity = 0;
        }
    }

    public void addFuel(double capacity) {
        fuelCapacity += capacity;
    }

    public double getDistance() {
        return x;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }
}
