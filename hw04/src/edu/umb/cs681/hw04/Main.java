package edu.umb.cs681.hw04;

public class Main {
    public static void main(String[] args) throws Exception {

        // Using one thread
        System.out.println("Using One Threads");
        var run1 = new RunnablePrimeGenerator(1L, 2_000_000L);

        var thread1 = new Thread(run1);

        var startTime = System.nanoTime();
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        var endTime = System.nanoTime();

        long primeCountOneThread = run1.getPrimes().size();
        var oneThreadDuration = (endTime - startTime) / 1_000_000L;
        System.out.println(primeCountOneThread + " prime numbers are found in total.");
        System.out.println("Time taken with one thread: " + oneThreadDuration + " milliseconds");

        // Using two threads
        System.out.println("\n############################\n");
        System.out.println("Using Two Threads");
        var run2 = new RunnablePrimeGenerator(1L, 1_000_000L);
        var run3 = new RunnablePrimeGenerator(1_000_000L, 2_000_000L);

        var thread2 = new Thread(run2);
        var thread3 = new Thread(run3);

        startTime = System.nanoTime();
        thread2.start();
        thread3.start();

        try {
            thread2.join();
            thread3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        endTime = System.nanoTime();

        long primeCountTwoThreads = run2.getPrimes().size() + run3.getPrimes().size();
        var twoThreadDuration = (endTime - startTime) / 1_000_000L;
        System.out.println(primeCountTwoThreads + " prime numbers are found in total.");
        System.out.println("Time taken with two threads: " + twoThreadDuration + " milliseconds");


        // Using four threads
        System.out.println("\n############################\n");
        System.out.println("Using Four Threads");
        var run7 = new RunnablePrimeGenerator(1L, 500_000L);
        var run8 = new RunnablePrimeGenerator(500_000L, 1_000_000L);
        var run9 = new RunnablePrimeGenerator(1_000_000L, 1_500_000L);
        var run10 = new RunnablePrimeGenerator(1_500_000L, 2_000_000L);

        var thread7 = new Thread(run7);
        var thread8 = new Thread(run8);
        var thread9 = new Thread(run9);
        var thread10 = new Thread(run10);

        startTime = System.nanoTime();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

        try {
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        endTime = System.nanoTime();

        long primeCountFourThreads = run7.getPrimes().size() + run8.getPrimes().size() + run9.getPrimes().size() + run10.getPrimes().size();
        var fourThreadDuration = (endTime - startTime) / 1_000_000;
        System.out.println(primeCountFourThreads + " prime numbers are found in total.");
        System.out.println("Time taken with four threads: " + fourThreadDuration + " milliseconds");


        // Using eight threads
        System.out.println("\n############################\n");
        System.out.println("Using Eight Threads");
        var run11 = new RunnablePrimeGenerator(1L, 250_000L);
        var run12 = new RunnablePrimeGenerator(250_000L, 500_000L);
        var run13 = new RunnablePrimeGenerator(500_000L, 750_000L);
        var run14 = new RunnablePrimeGenerator(750_000L, 1_000_000L);
        var run15 = new RunnablePrimeGenerator(1_000_000L, 1_250_000L);
        var run16 = new RunnablePrimeGenerator(1_250_000L, 1_500_000L);
        var run17 = new RunnablePrimeGenerator(1_500_000L, 1_750_000);
        var run18 = new RunnablePrimeGenerator(1_750_000L, 2_000_000L);

        var thread11 = new Thread(run11);
        var thread12 = new Thread(run12);
        var thread13 = new Thread(run13);
        var thread14 = new Thread(run14);
        var thread15 = new Thread(run15);
        var thread16 = new Thread(run16);
        var thread17 = new Thread(run17);
        var thread18 = new Thread(run18);

        startTime = System.nanoTime();
        thread11.start();
        thread12.start();
        thread13.start();
        thread14.start();
        thread15.start();
        thread16.start();
        thread17.start();
        thread18.start();

        try {
            thread11.join();
            thread12.join();
            thread13.join();
            thread14.join();
            thread15.join();
            thread16.join();
            thread17.join();
            thread18.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        endTime = System.nanoTime();

        long primeCountEightThreads = run11.getPrimes().size() + run12.getPrimes().size() + run13.getPrimes().size() + run14.getPrimes().size() + run15.getPrimes().size() + run16.getPrimes().size() + run17.getPrimes().size() + run18.getPrimes().size();
        var eightThreadDuration = (endTime - startTime) / 1_000_000;
        System.out.println(primeCountEightThreads + " prime numbers are found in total.");
        System.out.println("Time taken with eight threads: " + eightThreadDuration + " milliseconds");

        // Using sixteen threads
        System.out.println("\n############################\n");
        System.out.println("Using Sixteen Threads");
        var run21 = new RunnablePrimeGenerator(1L, 125_000L);
        var run22 = new RunnablePrimeGenerator(125_000L, 250_000L);
        var run23 = new RunnablePrimeGenerator(250_000L, 375_000L);
        var run24 = new RunnablePrimeGenerator(375_000L, 500_000L);
        var run25 = new RunnablePrimeGenerator(500_000L, 625_000L);
        var run26 = new RunnablePrimeGenerator(625_000L, 750_000L);
        var run27 = new RunnablePrimeGenerator(750_000L, 875_000L);
        var run28 = new RunnablePrimeGenerator(875_000L, 1_000_000L);
        var run29 = new RunnablePrimeGenerator(1_000_000L, 1_125_000L);
        var run30 = new RunnablePrimeGenerator(1_125_000L, 1_250_000L);
        var run31 = new RunnablePrimeGenerator(1_250_000L, 1_375_000L);
        var run32 = new RunnablePrimeGenerator(1_375_000L, 1_500_000L);
        var run33 = new RunnablePrimeGenerator(1_500_000L, 1_625_000L);
        var run34 = new RunnablePrimeGenerator(1_625_000L, 1_750_000L);
        var run35 = new RunnablePrimeGenerator(1_750_000L, 1_875_000L);
        var run36 = new RunnablePrimeGenerator(1_875_000L, 2_000_000L);

        var thread21 = new Thread(run21);
        var thread22 = new Thread(run22);
        var thread23 = new Thread(run23);
        var thread24 = new Thread(run24);
        var thread25 = new Thread(run25);
        var thread26 = new Thread(run26);
        var thread27 = new Thread(run27);
        var thread28 = new Thread(run28);
        var thread29 = new Thread(run29);
        var thread30 = new Thread(run30);
        var thread31 = new Thread(run31);
        var thread32 = new Thread(run32);
        var thread33 = new Thread(run33);
        var thread34 = new Thread(run34);
        var thread35 = new Thread(run35);
        var thread36 = new Thread(run36);

        startTime = System.nanoTime();
        thread21.start();
        thread22.start();
        thread23.start();
        thread24.start();
        thread25.start();
        thread26.start();
        thread27.start();
        thread28.start();
        thread29.start();
        thread30.start();
        thread31.start();
        thread32.start();
        thread33.start();
        thread34.start();
        thread35.start();
        thread36.start();

        try {
            thread21.join();
            thread22.join();
            thread23.join();
            thread24.join();
            thread25.join();
            thread26.join();
            thread27.join();
            thread28.join();
            thread29.join();
            thread30.join();
            thread31.join();
            thread32.join();
            thread33.join();
            thread34.join();
            thread35.join();
            thread36.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        endTime = System.nanoTime();

        long primeCountSixteenThreads = run21.getPrimes().size() + run22.getPrimes().size() + run23.getPrimes().size() + run24.getPrimes().size() + run25.getPrimes().size() + run26.getPrimes().size() + run27.getPrimes().size() + run28.getPrimes().size() + run29.getPrimes().size() + run30.getPrimes().size() + run31.getPrimes().size() + run32.getPrimes().size() + run33.getPrimes().size() + run34.getPrimes().size() + run35.getPrimes().size() + run36.getPrimes().size();
        var sixteenThreadDuration = (endTime - startTime) / 1_000_000;
        System.out.println(primeCountSixteenThreads + " prime numbers are found in total.");
        System.out.println("Time taken with sixteen threads: " + sixteenThreadDuration + " milliseconds");

        // Printing in a formatted way
        System.out.println();
        System.out.println();
        System.out.print("# of threads\t");
        System.out.print("Time(milliseconds)\t");
        System.out.println("Time(seconds)");

        System.out.print("1 thread\t\t");
        System.out.print(oneThreadDuration + "\t\t\t\t");
        System.out.println(oneThreadDuration / (double) 1000);
        System.out.print("2 threads\t\t");
        System.out.print(twoThreadDuration + "\t\t\t\t\t");
        System.out.println(twoThreadDuration / (double) 1000);
        System.out.print("4 threads\t\t");
        System.out.print(fourThreadDuration + "\t\t\t\t\t");
        System.out.println(fourThreadDuration / (double) 1000);
        System.out.print("8 threads\t\t");
        System.out.print(eightThreadDuration + "\t\t\t\t\t");
        System.out.println(eightThreadDuration / (double) 1000);
        System.out.print("16 threads\t\t");
        System.out.print(sixteenThreadDuration + "\t\t\t\t\t");
        System.out.println(sixteenThreadDuration / (double) 1000);

    }
}
