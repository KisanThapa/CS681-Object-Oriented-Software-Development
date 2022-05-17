package edu.umb.cs681.hw18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        int number = 84;
        System.out.println("Prime Factorization of " + number + " using two fixed threads pools");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new RunnablePrimeFactorizer(number, 2, (long) Math.sqrt(number) / 2));
        executor.execute(new RunnablePrimeFactorizer(number, 1 + (long) Math.sqrt(number) / 2, (long) Math.sqrt(number)));

        executor.shutdown();
    }
}
