package edu.umb.cs681.hw01;

import java.util.ArrayList;

public class Car {
    private final String model;
    private final String make;
    private final int mileage;
    private final int year;
    private final float price;
    private ArrayList<Car> cars;
    private int dominationCount = 0;

    public Car(String model, String make, int mileage, int year, float price) {
        this.model = model;
        this.make = make;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public void setDominationCount(int dominationCount) {
        this.dominationCount = dominationCount;
    }

    public void dominationCount() {
        int count = 0;
        for (Car c : cars)
            if (price >= c.getPrice() && this.year >= c.getYear() && this.mileage >= c.getMileage())
                count++;
        setDominationCount(count);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", mileage=" + mileage +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
