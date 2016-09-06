package com.carlisle.android.aca.primefinder;

/**
 * Created by chriscarlisle on 9/2/16.
 */
public class PrimeFinder implements Runnable{

    public long target;
    public long prime;
    public boolean finished = false;
    private Thread runner;

    PrimeFinder (long inTarget) {
        target = inTarget;
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }

    }
    @Override
    public void run() {
        long numPrimes = 0;
        long candidate = 2;

        while (numPrimes < target) {
            if (IsPrime(candidate)) {
                numPrimes++;
                prime = candidate;
                System.out.println("Prime Candidate; " + prime);
            }
            candidate++;
            System.out.println("Number of Prime;" + numPrimes);
            finished = true;
        }
    }

    boolean IsPrime(long checkNumber) {
        double root = Math.sqrt(checkNumber);

        for (int i = 2; i <= root; i++) {
            if (checkNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

}
