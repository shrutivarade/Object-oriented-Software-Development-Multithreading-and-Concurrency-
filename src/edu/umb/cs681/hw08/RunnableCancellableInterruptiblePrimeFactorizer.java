package edu.umb.cs681.hw08;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer{

    public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
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
        runnable1.setDone();
        thread1.interrupt();
        System.out.println("Is "+thread1.threadId()+" Interrupted: "+thread1.isInterrupted());
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
        runnable2.setDone();
        thread2.interrupt();
        System.out.println("Is "+thread2.threadId()+" Interrupted: "+thread2.isInterrupted());
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final result: " + runnable2.getPrimeFactors() + "\n");


    }
}
