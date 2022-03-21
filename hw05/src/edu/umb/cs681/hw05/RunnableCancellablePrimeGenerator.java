package edu.umb.cs681.hw05;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator {
    private final ReentrantLock lock = new ReentrantLock();
    private boolean done = false;

    public RunnableCancellablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void setDone() {
        lock.lock();
        try {
            done = true;
        } finally {
            lock.unlock();
        }
    }

    public void generatePrimes() {
        for (long n = from; n <= to; n++) {
            lock.lock();
            // Stop generating prime numbers if done==true
            try {
                if (done) {
                    System.out.println("Stopped generating prime numbers.");
                    this.primes.clear();
                    break;
                }
                if (isPrime(n))
                    this.primes.add(n);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        var gen = new RunnableCancellablePrimeGenerator(1, 500);
        var thread = new Thread(gen);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gen.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
        System.out.println("\n" + gen.getPrimes().size() + " prime numbers are found.");
    }
}
