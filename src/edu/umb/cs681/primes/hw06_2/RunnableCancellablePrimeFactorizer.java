package edu.umb.cs681.primes.hw06_2;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer{

    private boolean done = false; //added flag variable done
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }

    public void setDone(){
        lock.lock(); //added reentrantLock to guard the shared variable 'done'
        try{
            done = true;
        }
        finally{
            lock.unlock();
        }

    }

    public void generatePrimeFactors() { //revised prime generator
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

    public void run() {
        generatePrimeFactors();
        System.out.println("Thread #" + Thread.currentThread().threadId() + " generated " + factors);
    }


    public static void main(String[] args) {

        // Factorization of 36 with a separate thread
        System.out.println("Factorization of 36");
        RunnableCancellablePrimeFactorizer fact = new RunnableCancellablePrimeFactorizer(36, 2, (long)Math.sqrt(36));
        Thread thread = new Thread(fact);
        System.out.println("Thread #" + thread.threadId() +
                " performs factorization in the range of " + fact.getFrom() + "->" + fact.getTo());
        thread.start();
        fact.setDone();
        try{
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Final result: " + fact.getPrimeFactors() + "\n");


    }





}
