import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

//        var allLines =
                Files.readAllLines(Paths.get("src/data/pvi_data.csv"))
                .stream()
                .map(line -> Arrays.asList(line.split(",")))
//                .filter(lineArray -> lineArray.get(3).equals("Massachusetts, Norfolk"))
//                .collect(Collectors.toList());
                .forEach(System.out::println);

//        System.out.println(allLines);

    }
}
