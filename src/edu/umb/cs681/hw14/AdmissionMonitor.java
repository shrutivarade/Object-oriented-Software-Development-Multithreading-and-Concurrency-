package edu.umb.cs681.hw14;


import java.time.Duration;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class AdmissionMonitor{
    private int currentVisitors = 0;
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    private Condition enter = rwlock.writeLock().newCondition();

    public void enter() {
        rwlock.writeLock().lock();
        try {
            System.out.println("\nEnter Lock obtained");
            System.out.println("Current Visitors: "+currentVisitors);
            while (currentVisitors >= 10) {
//                System.out.println("Current Visitors trying to enter: "+(currentVisitors+1));
                System.out.println("Too many visitors. Please wait a while");
                System.out.println("Calls await()");
                enter.await();
            }
            currentVisitors++;
            System.out.println("Current Visitors entered: "+currentVisitors);
        } catch (InterruptedException e) {
        } finally {
            rwlock.writeLock().unlock();
        }
    }
    public void exit(){
        rwlock.writeLock().lock();
        try {
            System.out.println("\nExit Lock obtained");
            if(currentVisitors>0){
                currentVisitors--;
            }
            System.out.println("Current Visitors exited: "+(currentVisitors+1));
            enter.signalAll();
        }
        finally {
            rwlock.writeLock().unlock();
        }
    }
    public int countCurrentVisitors(){
        rwlock.readLock().lock();
        try {
            System.out.println("\nStats Lock obtained");
            return currentVisitors;
        }
        finally {
            rwlock.readLock().unlock();
        }
    }

    public static void main(String[] args) {

        AdmissionMonitor monitor = new AdmissionMonitor();

        EntranceHandler entrance = new EntranceHandler(monitor);
        ExitHandler exit = new ExitHandler(monitor);
        StatsHandler stats = new StatsHandler(monitor);


        Thread t1 = new Thread(entrance);
        Thread t2 = new Thread(exit);
        Thread t3 = new Thread(stats);

        t1.start();
        try {
            Thread.sleep(10000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        t2.start();
        try {
            Thread.sleep(5000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }

        entrance.setFlagAtomic();
        t1.interrupt();
        exit.setFlagAtomic();
        t2.interrupt();

        t3.start();
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }

        entrance.setFlagAtomic();
        t1.interrupt();
        exit.setFlagAtomic();
        t2.interrupt();
        stats.setFlagAtomic();
        t3.interrupt();


    }
}