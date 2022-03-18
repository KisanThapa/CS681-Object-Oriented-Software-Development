import java.util.ArrayList;
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

        var byYearAscending = cars.stream()
                .sorted((Car car1, Car car2) -> car1.getYear() - car2.getYear())
                .collect(Collectors.toList());

        var byYearDescending = cars.stream()
                .sorted((Car car1, Car car2) -> car2.getYear() - car1.getYear())
                .collect(Collectors.toList());

        var byMileageAscending = cars.stream()
                .sorted((Car car1, Car car2) -> car1.getMileage() - car2.getMileage())
                .collect(Collectors.toList());

        var byMileageDescending = cars.stream()
                .sorted((Car car1, Car car2) -> car2.getMileage() - car1.getMileage())
                .collect(Collectors.toList());


        var byPriceAscending = cars.stream()
                .sorted((Car car1, Car car2) -> Math.round(car1.getPrice() - car2.getPrice()))
                .collect(Collectors.toList());
        var byPriceDescending = cars.stream()
                .sorted((Car car1, Car car2) -> Math.round(car2.getPrice() - car1.getPrice()))
                .collect(Collectors.toList());


        var byDominationAscending = cars.stream()
                .sorted((Car car1, Car car2) -> car1.getDominationCount() - car2.getDominationCount())
                .collect(Collectors.toList());

        var byDominationDescending = cars.stream()
                .sorted((Car car1, Car car2) -> car2.getDominationCount() - car1.getDominationCount())
                .collect(Collectors.toList());
        
        System.out.println(byPriceAscending);
        System.out.println(byPriceDescending);

    }
}
