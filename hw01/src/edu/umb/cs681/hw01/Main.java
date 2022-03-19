package edu.umb.cs681.hw01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> cars = new ArrayList<>();

        cars.add(new Car("Rav 4", "Toyota", 60, 2015, 5000f));
        cars.add(new Car("320i", "BMW", 40, 2018, 35000f));
        cars.add(new Car("A3", "Audi", 30, 2021, 40000f));
        cars.add(new Car("Acadia", "GMC", 45, 2017, 25000f));
        cars.add(new Car("Accord", "Honda", 50, 2016, 27000f));
        cars.add(new Car("Accent", "Hyundai", 53, 2013, 15000f));


        System.out.println("Sorting cars by year in ascending order");
        var byYearAscending = cars.stream()
                .sorted(Comparator.comparingInt(Car::getYear))
                .collect(Collectors.toList());
        byYearAscending.forEach(System.out::println);

        System.out.println("\nSorting cars by year in descending order");
        var byYearDescending = cars.stream()
                .sorted((Car car1, Car car2) -> car2.getYear() - car1.getYear())
                .collect(Collectors.toList());
        byYearDescending.forEach(System.out::println);


        System.out.println("\n\nSorting cars by mileage in ascending order");
        var byMileageAscending = cars.stream()
                .sorted(Comparator.comparingInt(Car::getMileage))
                .collect(Collectors.toList());
        byMileageAscending.forEach(System.out::println);

        System.out.println("\nSorting cars by mileage in descending order");
        var byMileageDescending = cars.stream()
                .sorted((Car car1, Car car2) -> car2.getMileage() - car1.getMileage())
                .collect(Collectors.toList());
        byMileageDescending.forEach(System.out::println);


        System.out.println("\n\nSorting cars by price in ascending order");
        var byPriceAscending = cars.stream()
                .sorted(Comparator.comparingDouble(Car::getPrice))
                .collect(Collectors.toList());
        byPriceAscending.forEach(System.out::println);

        System.out.println("\nSorting cars by price in descending order");
        var byPriceDescending = cars.stream()
                .sorted((Car car1, Car car2) -> Math.round(car2.getPrice() - car1.getPrice()))
                .collect(Collectors.toList());
        byPriceDescending.forEach(System.out::println);


        System.out.println("\n\nSorting cars by domination count in ascending order");
        cars.forEach(car -> {
            car.setCars(cars);
            car.dominationCount();
        });  // Setting domination count first

        var byDominationAscending = cars.stream()
                .sorted(Comparator.comparingInt(Car::getDominationCount))
                .collect(Collectors.toList());
        byDominationAscending.forEach(System.out::println);

        System.out.println("\nSorting cars by domination count in descending order");
        var byDominationDescending = cars.stream()
                .sorted((Car car1, Car car2) -> car2.getDominationCount() - car1.getDominationCount())
                .collect(Collectors.toList());
        byDominationDescending.forEach(System.out::println);
    }
}
