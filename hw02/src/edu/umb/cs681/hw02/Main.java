package edu.umb.cs681.hw02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> cars = new ArrayList<>();

        cars.add(new Car("Rav 4", "Toyota", 60, 2015, 5000));
        cars.add(new Car("320i", "BMW", 40, 2018, 35000));
        cars.add(new Car("A3", "Audi", 30, 2021, 40000));
        cars.add(new Car("Acadia", "GMC", 45, 2017, 25000));
        cars.add(new Car("Accord", "Honda", 50, 2016, 27000));
        cars.add(new Car("Accent", "Hyundai", 53, 2013, 15000));


        System.out.print("Minimum price of the car: ");
        var minPrice = cars.stream().map(Car::getPrice).min(Comparator.comparing((Integer price) -> price)).get();
        System.out.println(minPrice);

        System.out.print("Maximum price of the car: ");
        var maxPrice = cars.stream().map(Car::getPrice).max(Comparator.comparing((Integer price) -> price)).get();
        System.out.println(maxPrice);


        System.out.print("Average price of all cars: ");
        var averagePrice = cars.stream()
                .map(Car::getPrice)
                .reduce(new int[2], (result, price) -> {
                    var r = (result[1] * result[0] + price) / ++result[0];
                    return new int[]{result[0]++, r};
                }, (finalResult, intermediateResult) -> finalResult)[1];
        System.out.println(averagePrice);

    }
}
