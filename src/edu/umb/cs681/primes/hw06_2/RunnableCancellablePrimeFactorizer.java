package edu.umb.cs681.primes.hw06_2;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer{

    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }

    public void setDone(){
        lock.lock();
        try{
            done = true;
        }
        finally{
            lock.unlock();
        }

    }

    public void generatePrimeFactors() {
        long divisor = 2;
        while( dividend != 1 && divisor <= to ){

            lock.lock();
            try{
                // Stop generating prime factors if done==true
                if(done){
                    System.out.println("Stopped generating prime factors.");
                    this.factors.clear();
                    break;
                }
                if(dividend % divisor == 0) {
                    factors.add(divisor);
                    dividend /= divisor;
                }else {
                    if (divisor == 2) {
                        divisor++;
                    } else {
                        divisor += 2;
                    }
                }
            }
            finally {
                lock.unlock();
            }

        }
    }



}
