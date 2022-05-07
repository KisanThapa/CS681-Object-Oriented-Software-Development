package edu.umb.cs681.hw16;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda", "Civic", 2017, 30, 10_000f));
        cars.add(new Car("Ford", "Fiesta", 2012, 20, 8_000f));
        cars.add(new Car("Honda", "Accord", 2010, 20, 5_000f));
        cars.add(new Car("Toyota", "Prius", 2002, 20, 1_000f));
        cars.add(new Car("Ford", "Focus", 2006, 20, 3_000f));
        cars.add(new Car("Toyota", "Camry", 2008, 20, 4_000f));
        cars.add(new Car("Honda", "Fit", 2004, 20, 2_000f));
        cars.add(new Car("Toyota", "Corolla", 2015, 20, 16_000f));
        cars.add(new Car("Honda", "CR-V", 2010, 20, 7_000f));


        Integer carMakeNum = cars
                .stream()
                .parallel()
                .map((Car car) -> car.getMake())
                .reduce(
                        0,
                        (result, make) -> ++result,
                        (finalResult, intermediateResult) -> finalResult + intermediateResult
                );

        System.out.println("Number of car makes: " + carMakeNum);


        Integer carModelNum = cars
                .stream()
                .parallel()
                .map((Car car) -> car.getModel())
                .reduce(
                        0,
                        (result, model) -> ++result,
                        (finalResult, intermediateResult) -> finalResult + intermediateResult
                );

        System.out.println("Number of car models: " + carModelNum);
    }
}
