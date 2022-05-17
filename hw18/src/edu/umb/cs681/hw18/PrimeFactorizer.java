package edu.umb.cs681.hw18;

import java.util.LinkedList;

// Generates prime factors of a given number (dividend)
// Prime factors are generated in the range of 2 and dividend
// from:	lower bound of the range (2)
// to:		upper bound of the range (dividend)

public class PrimeFactorizer {
    protected long dividend, from, to;
    protected LinkedList<Long> factors = new LinkedList<>();

    public PrimeFactorizer(long dividend) {
        if (dividend >= 2) {
            this.dividend = dividend;
            this.from = 2;
            this.to = dividend;
        } else {
            throw new RuntimeException("dividend must be >= 2. dividend==" + dividend);
        }
    }

    public long getDividend() {
        return dividend;
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public LinkedList<Long> getPrimeFactors() {
        return factors;
    }

    public void generatePrimeFactors() {
        long divisor = 2;
        while (dividend != 1 && divisor <= to) {
            if (dividend % divisor == 0) {
                factors.add(divisor);
                dividend /= divisor;
            } else {
                if (divisor == 2) divisor++;
                else divisor += 2;
            }
        }
    }
}
