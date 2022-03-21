package edu.umb.cs681.hw05;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

    public RunnablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public static void main(String[] args) {
        var gen1 = new RunnablePrimeGenerator(1, 100);
        var gen2 = new RunnablePrimeGenerator(101, 200);

        var t1 = new Thread(gen1);
        var t2 = new Thread(gen2);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        gen1.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
        gen2.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));

        long primeNum = gen1.getPrimes().size() + gen2.getPrimes().size();
        System.out.println("\n" + primeNum + " prime numbers are found in total.");
    }

    public void run() {
        generatePrimes();
    }
}

