package edu.umb.cs681.hw08;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer{


    private boolean done = false;

    private final ReentrantLock lock = new ReentrantLock();

    public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
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
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                System.out.println(e.toString());
                continue;
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
        RunnableCancellableInterruptiblePrimeFactorizer runnable1 = new RunnableCancellableInterruptiblePrimeFactorizer(36, 2, (long)Math.sqrt(36));
        Thread thread1 = new Thread(runnable1);
        System.out.println("Thread #" + thread1.threadId() +
                " performs factorization in the range of " + runnable1.getFrom() + "->" + runnable1.getTo());
        thread1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runnable1.setDone();
        thread1.interrupt();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final result: " + runnable1.getPrimeFactors() + "\n");

        // Factorization of 36 with a separate thread
        System.out.println("Factorization of 84");
        RunnableCancellableInterruptiblePrimeFactorizer runnable2 = new RunnableCancellableInterruptiblePrimeFactorizer(84, 2, (long)Math.sqrt(84));
        Thread thread2 = new Thread(runnable2);
        System.out.println("Thread #" + thread2.threadId() +
                " performs factorization in the range of " + runnable2.getFrom() + "->" + runnable2.getTo());
        thread2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runnable2.setDone();
        thread2.interrupt();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final result: " + runnable2.getPrimeFactors() + "\n");


    }
}
