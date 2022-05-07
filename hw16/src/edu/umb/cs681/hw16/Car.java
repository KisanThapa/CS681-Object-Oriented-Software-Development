package edu.umb.cs681.hw16;

public class Car {

    private String make, model;
    private int mileage, year;
    private float price;

    public Car(String make, String model, int year, int mileage, float price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getModel() {
        return this.model;
    }

    public String getMake() {
        return this.make;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getYear() {
        return this.year;
    }

    public float getPrice() {
        return this.price;
    }
}