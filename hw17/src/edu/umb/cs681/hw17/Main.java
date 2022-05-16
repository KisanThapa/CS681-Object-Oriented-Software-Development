package edu.umb.cs681.hw17;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        var path = Paths.get("src/edu/umb/cs681/hw17/data/pvi_data.csv");

        // Finding my neighbouring counties
        var neighbouringCounties = Files.readAllLines(path)
                .stream()
                .parallel()
                .filter(line -> line.contains("Massachusetts, Norfolk")
                        || line.contains("Massachusetts, Worcester")
                        || line.contains("Massachusetts, Middlesex")
                        || line.contains("Massachusetts, Suffolk")
                        || line.contains("Massachusetts, Plymouth")
                        || line.contains("Massachusetts, Bristol")
                        || line.contains("Rhode Island, Providence"))
                .map(line -> line.split(","))
                .collect(Collectors.toList());

        var avPvi = neighbouringCounties.stream()
                .parallel()
                .map(line -> Double.parseDouble(line[0].replace("\"", "")))
                .reduce(
                        new double[2],
                        (result, pvi) -> {
                            var av = (result[1] * result[0] + pvi) / ++result[0];
                            return new double[]{result[0]++, av};
                        },
                        (finalResult, intermediateResult) -> finalResult)[1];


        System.out.print("Average PVI of my neighbouring counties and my counties is: ");
        System.out.println(avPvi);

        var avInfectionRate = neighbouringCounties.stream()
                .parallel()
                .map(line -> Double.parseDouble(line[7].replace("\"", "")))
                .reduce(
                        new double[2],
                        (result, pvi) -> {
                            var av = (result[1] * result[0] + pvi) / ++result[0];
                            return new double[]{result[0]++, av};
                        },
                        (finalResult, intermediateResult) -> finalResult)[1];
        System.out.print("Average infection rate of my neighbouring counties and my counties is: ");
        System.out.println(avInfectionRate);

        var avVaxRate = neighbouringCounties.stream()
                .parallel()
                .map(line -> Double.parseDouble(line[11].replace("\"", "")))
                .reduce(
                        new double[2],
                        (result, pvi) -> {
                            var av = (result[1] * result[0] + pvi) / ++result[0];
                            return new double[]{result[0]++, av};
                        },
                        (finalResult, intermediateResult) -> finalResult)[1];
        System.out.print("Average vaccination rate of my neighbouring counties and my counties is: ");
        System.out.println(avVaxRate);

        // Calculate Standard Deviation of Massachusetts counties
        // Finding Massachusetts counties
        var massCounties = Files.readAllLines(path)
                .stream()
                .parallel()
                .filter(line -> line.contains("Massachusetts"))
                .map(line -> line.split(","))
                .collect(Collectors.toList());

        var meanPVI = massCounties.stream()
                .parallel()
                .map(line -> Double.parseDouble(line[0].replace("\"", "")))
                .reduce(
                        new double[2],

                        (result, pvi) -> {
                            var av = (result[1] * result[0] + pvi) / ++result[0];
                            return new double[]{result[0]++, av};
                        },
                        (finalResult, intermediateResult) -> finalResult)[1];

        var massSD = 0.0d;
        for (String[] county : massCounties) {
            var a = Double.parseDouble(county[0].replace("\"", ""));
            massSD += Math.pow(a - meanPVI, 2);
        }
        massSD = Math.sqrt(massSD / massCounties.size());
        System.out.println("Mean of massachusetts counties: " + meanPVI);
        System.out.print("Standard Deviation of massachusetts counties: ");
        System.out.println(massSD);

    }
}