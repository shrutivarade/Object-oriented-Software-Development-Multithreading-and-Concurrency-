package edu.umb.cs681.hw11;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable{

    private ReentrantLock lock = new ReentrantLock();
    private AccessCounter counter = AccessCounter.getInstance();

    private AtomicBoolean flagAtomic = new AtomicBoolean(false);
    public void setFlagAtomic() {
        flagAtomic.set(true);
    }

    int countA = 0, countB = 0, countC = 0;
    private static final Path[] files = {
            Path.of("a.html"),
            Path.of("b.html"),
            Path.of("c.html"),
            Path.of("d.html")
    };
    private static final Random rand = new Random();
    public void handleRequests() {
        while (true) {

            lock.lock();
            try {
                if (flagAtomic.get()) {
                    break;
                }
                Path file = files[rand.nextInt(files.length)];
                counter.increment(file);
                System.out.println(file + ": " + counter.getCount(file));
                try {
                    Thread.sleep(rand.nextInt(2000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                //                counter.increment(Paths.get("/Users/shrutiv/JAVA/CS681-OOSD/src/edu/umb/cs681/hw11/a.html"));
                //                countA = counter.getCount(Paths.get("/Users/shrutiv/JAVA/CS681-OOSD/src/edu/umb/cs681/hw11/a.html"));
                //                System.out.println("countA: "+countA);
                //
                //                counter.increment(Path.of("b.html"));
                //                countB = counter.getCount(Path.of("b.html"));
                //                System.out.println("countB: "+countB);
                //
                //                countC = counter.getCount(Path.of("c.html"));
                //                System.out.println("countB: "+countC);
            }
            finally{
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

    @Override
    public void run() {
        handleRequests();
    }

    public static void main(String[] args) {

        RequestHandler req1 = new RequestHandler();
        RequestHandler req2 = new RequestHandler();
        RequestHandler req3 = new RequestHandler();
        RequestHandler req4 = new RequestHandler();
        RequestHandler req5 = new RequestHandler();
        RequestHandler req6 = new RequestHandler();
        RequestHandler req7 = new RequestHandler();
        RequestHandler req8 = new RequestHandler();
        RequestHandler req9 = new RequestHandler();
        RequestHandler req10 = new RequestHandler();
        RequestHandler req11 = new RequestHandler();
        RequestHandler req12 = new RequestHandler();
        RequestHandler req13 = new RequestHandler();
        RequestHandler req14 = new RequestHandler();
        RequestHandler req15 = new RequestHandler();

        Thread t1 = new Thread(req1);
        Thread t2 = new Thread(req2);
        Thread t3 = new Thread(req3);
        Thread t4 = new Thread(req4);
        Thread t5 = new Thread(req5);
        Thread t6 = new Thread(req6);
        Thread t7 = new Thread(req7);
        Thread t8 = new Thread(req8);
        Thread t9 = new Thread(req9);
        Thread t10 = new Thread(req10);
        Thread t11 = new Thread(req11);
        Thread t12 = new Thread(req12);
        Thread t13 = new Thread(req13);
        Thread t14 = new Thread(req14);
        Thread t15 = new Thread(req15);

        t1.start();
        System.out.println("Thread #" + t1.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req1.setFlagAtomic();
        t1.interrupt();

        t2.start();
        System.out.println("Thread #" + t2.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req2.setFlagAtomic();
        t2.interrupt();

        t3.start();
        System.out.println("Thread #" + t3.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req3.setFlagAtomic();
        t3.interrupt();

        t4.start();
        System.out.println("Thread #" + t4.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req4.setFlagAtomic();
        t4.interrupt();

        t5.start();
        System.out.println("Thread #" + t5.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req5.setFlagAtomic();
        t5.interrupt();

        t6.start();
        System.out.println("Thread #" + t6.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req6.setFlagAtomic();
        t6.interrupt();

        t7.start();
        System.out.println("Thread #" + t7.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req7.setFlagAtomic();
        t7.interrupt();

        t8.start();
        System.out.println("Thread #" + t8.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req8.setFlagAtomic();
        t8.interrupt();

        t9.start();
        System.out.println("Thread #" + t9.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req9.setFlagAtomic();
        t9.interrupt();

        t10.start();
        System.out.println("Thread #" + t10.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req10.setFlagAtomic();
        t10.interrupt();

        t11.start();
        System.out.println("Thread #" + t11.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req11.setFlagAtomic();
        t11.interrupt();

        t12.start();
        System.out.println("Thread #" + t12.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req12.setFlagAtomic();
        t12.interrupt();

        t13.start();
        System.out.println("Thread #" + t13.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req13.setFlagAtomic();
        t13.interrupt();

        t14.start();
        System.out.println("Thread #" + t14.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req14.setFlagAtomic();
        t14.interrupt();

        t15.start();
        System.out.println("Thread #" + t15.threadId());
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.toString());
        }
        req15.setFlagAtomic();
        t15.interrupt();

    }
}
