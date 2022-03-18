import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        // var allLines = Files.readAllLines(Paths.get("/data/pvi_data.csv"))
        //         .stream()
        //         .map(line -> Arrays.asList(line.split(",")))
        //         .collect(Collectors.toList());

        // System.out.println(allLines);

        System.out.println(Paths.get("/data/pvi_data.csv"));
    }
}
