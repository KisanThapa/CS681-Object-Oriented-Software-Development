package edu.umb.cs681.hw08;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer {
    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }

    public void setDone() {
        lock.lock();
        try {
            done = false;
        } finally {
            lock.unlock();
        }
    }

    public void generatePrimeFactors() {
        long divisor = from;
        while (dividend != 1 && divisor <= to) {
            lock.lock();
            try {
                if (done) {
                    System.out.println("Factors generation stopped");
                    this.factors.clear();
                    break;
                }
                if (divisor > 2 && isEven(divisor)) {
                    divisor++;
                    continue;
                }
                if (dividend % divisor == 0) {
                    factors.add(divisor);
                    System.out.println(divisor);
                    dividend /= divisor;
                } else {
                    if (divisor == 2) {
                        divisor++;
                    } else {
                        divisor += 2;
                    }
                }
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }

    public static void main(String[] args) {
        var gen = new RunnableCancellableInterruptiblePrimeFactorizer(256, 2, 8);
        Thread thread = new Thread(gen);
        thread.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gen.setDone();
        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n" + gen.getPrimeFactors() + " are the prime factors.");


        System.out.print("Factors of 122 are	:\t\t");
        gen.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));

        var gen1 = new RunnableCancellableInterruptiblePrimeFactorizer(336, 3, 12);
        var gen2 = new RunnableCancellableInterruptiblePrimeFactorizer(24, 2, 20);

        var thread1 = new Thread(gen1);
        var thread2 = new Thread(gen2);

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gen1.setDone();
        gen2.setDone();
        thread1.interrupt();
        thread2.interrupt();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Factors of 336 are	:\t\t");
        gen1.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
        System.out.println();

        System.out.print("Factors of 24 are	:\t\t");
        gen2.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
    }

}