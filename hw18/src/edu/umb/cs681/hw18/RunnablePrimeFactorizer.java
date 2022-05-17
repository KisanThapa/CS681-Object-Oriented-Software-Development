package edu.umb.cs681.hw18;

// Generates prime factors of a given number (dividend)
// Factorization is performed in the range of 2 and Math.sqrt(dividend)
//
// When only one thread is used for factorization, create a Runnable as follows:
//     new RunnablePrimeFactorizer(dividend, 2, (long)Math.sqrt(dividend));
// The thread performs factorization for the entire range of 2 and sqrt(dividend).
//
// When two threads are used for factorization, create two Runnable as follows:
//     new RunnablePrimeFactorizer(dividend, 2, (long)Math.sqrt(dividend)/2);
//     new RunnablePrimeFactorizer(dividend, 1+(long)Math.sqrt(dividend)/2, (long)Math.sqrt(dividend));

public class RunnablePrimeFactorizer extends PrimeFactorizer implements Runnable {

    public RunnablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend);
        if (from >= 2 && to >= from) {
            this.from = from;
            this.to = to;
        } else {
            throw new RuntimeException("from must be >= 2, and to must be >= from." + "from==" + from + " to==" + to);
        }
    }

    protected boolean isEven(long n) {
        return n % 2 == 0;
    }

    public void generatePrimeFactors() {
        long divisor = from;
        while (dividend != 1 && divisor <= to) {
            if (divisor > 2 && isEven(divisor)) {
                divisor++;
                continue;
            }
            if (dividend % divisor == 0) {
                factors.add(divisor);
                dividend /= divisor;
            } else {
                if (divisor == 2)
                    divisor++;
                else
                    divisor += 2;
            }
        }
    }

    public void run() {
        generatePrimeFactors();
        System.out.println("Thread #" + Thread.currentThread().getId() + " generated " + factors);
    }
}
