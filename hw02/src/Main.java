import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> cars = new ArrayList<>();

        cars.add(new Car("Rav 4", "Toyota", 60, 2015, 5000f));
        cars.add(new Car("320i", "BMW", 40, 2018, 35000f));
        cars.add(new Car("A3", "Audi", 30, 2021, 40000f));
        cars.add(new Car("Acadia", "GMC", 45, 2017, 25000f));
        cars.add(new Car("Accord", "Honda", 50, 2016, 27000f));
        cars.add(new Car("Accent", "Hyundai", 53, 2013, 15000f));

        var minPrice = cars.stream()
                .map((Car car) -> car.getPrice())
                .min(Comparator.comparing((Float price) -> price))
                .get();

        // System.out.println(minPrice);

        var maxPrice = cars.stream()
                .map((Car car) -> car.getPrice())
                .max(Comparator.comparing((Float price) -> price))
                .get();

        // System.out.println(maxPrice);

        var averagePrice = cars.stream()
                .map(car -> Math.round(car.getPrice()))
                .reduce(0, (result, price) -> {
                    return result + price;
                });

        System.out.println(averagePrice);
    }
}
