package edu.umb.cs681.hw10;


import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;


public class RunnableFileSystem implements Runnable{


    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();
    public void setDone(){
        lock.lock();
        try{
            done = true;
        }
        finally{
            lock.unlock();
        }
    }
    private FileSystem fs;
    public void callFSElements() {
        while(true) {
            lock.lock();
            try {
                if (done) {
                    System.out.println("Thread ID: a" + Thread.currentThread().threadId() + " Stopped accessing FileSystem by flag based termination");
                    return;
                }
                fs = new TestFixture().createTextFixture();

                //FSElements methods
                System.out.println("\nFSElements methods");
                System.out.println("Parent of Apps: " + fs.getRootDirs().get(0).getChildren().get(1).getParent().getName());
                System.out.println("Time of d_link: " + fs.getRootDirs().get(0).getChildren().get(3).getCreationTime());
                System.out.println("Size of e_link: " + fs.getRootDirs().get(0).getChildren().get(4).getSize());

                //directory methods
                System.out.println("\nDirectory methods");
                System.out.println("Get files in directory Apps: " + fs.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).getName());
                System.out.println("Children in home directory: " + fs.getRootDirs().get(0).getSubDirectories().get(2).getChildren().stream().map(t -> t.getName()).collect(Collectors.toList()));
                System.out.println("Count Children in root Directory: " + fs.getRootDirs().get(0).countChildren());
                System.out.println("Get Total size of root: " + fs.getRootDirs().get(0).getTotalSize());

                //file methods
                System.out.println("\nFile  methods");
                System.out.println("is Apps a file, no: " + fs.getRootDirs().get(0).getSubDirectories().get(0).isFile());
                System.out.println("is d_link a Link, yes: " + fs.getRootDirs().get(0).getChildren().get(3).isLink());
                System.out.println("is Picture a directory, yes: " + fs.getRootDirs().get(0).getSubDirectories().get(2).getChildren().get(0).isDirectory());

                //link methods
                System.out.println("\nLink methods");
                System.out.println("Get target of link_d: " + new TestFixture().link_d.getTarget().getName());
                System.out.println("Size of target of link_e: " + new TestFixture().link_e.TargetSize());

                //filesystem methods
                System.out.println("Only 1 instance of filesystem: " + FileSystem.getFileSystem() + "\n");

            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }


    @Override
    public void run() {
        callFSElements();
    }

    public static void main(String[] args) {

        RunnableFileSystem app1 = new RunnableFileSystem();
        RunnableFileSystem app2 = new RunnableFileSystem();
        RunnableFileSystem app3 = new RunnableFileSystem();
        RunnableFileSystem app4 = new RunnableFileSystem();
        RunnableFileSystem app5 = new RunnableFileSystem();
        RunnableFileSystem app6 = new RunnableFileSystem();
        RunnableFileSystem app7 = new RunnableFileSystem();
        RunnableFileSystem app8 = new RunnableFileSystem();
        RunnableFileSystem app9 = new RunnableFileSystem();
        RunnableFileSystem app10 = new RunnableFileSystem();
        RunnableFileSystem app11 = new RunnableFileSystem();
        RunnableFileSystem app12 = new RunnableFileSystem();
        RunnableFileSystem app13 = new RunnableFileSystem();
        RunnableFileSystem app14 = new RunnableFileSystem();
        RunnableFileSystem app15 = new RunnableFileSystem();

        Thread t1 = new Thread(app1);
        Thread t2 = new Thread(app2);
        Thread t3 = new Thread(app3);
        Thread t4 = new Thread(app4);
        Thread t5 = new Thread(app5);
        Thread t6 = new Thread(app6);
        Thread t7 = new Thread(app7);
        Thread t8 = new Thread(app8);
        Thread t9 = new Thread(app9);
        Thread t10 = new Thread(app10);
        Thread t11 = new Thread(app11);
        Thread t12 = new Thread(app12);
        Thread t13 = new Thread(app13);
        Thread t14 = new Thread(app14);
        Thread t15 = new Thread(app15);


        System.out.println("\nThread ID:"+t1.threadId()+" Started");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app1.setDone();
        t1.interrupt();

        System.out.println("\nThread ID:"+t2.threadId()+" Started");
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app2.setDone();
        t2.interrupt();

        System.out.println("\nThread ID:"+t3.threadId()+" Started");
        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app3.setDone();
        t3.interrupt();

        System.out.println("\nThread ID:"+t4.threadId()+" Started");
        t4.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app4.setDone();
        t4.interrupt();

        System.out.println("\nThread ID:"+t5.threadId()+" Started");
        t5.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app5.setDone();
        t5.interrupt();

        System.out.println("\nThread ID:"+t6.threadId()+" Started");
        t6.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app6.setDone();
        t6.interrupt();

        System.out.println("\nThread ID:"+t7.threadId()+" Started");
        t7.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app7.setDone();
        t7.interrupt();

        System.out.println("\nThread ID:"+t8.threadId()+" Started");
        t8.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app8.setDone();
        t8.interrupt();

        System.out.println("\nThread ID:"+t9.threadId()+" Started");
        t9.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app9.setDone();
        t9.interrupt();

        System.out.println("\nThread ID:"+t10.threadId()+" Started");
        t10.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app10.setDone();
        t10.interrupt();

        System.out.println("\nThread ID:"+t11.threadId()+" Started");
        t11.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app11.setDone();
        t11.interrupt();

        System.out.println("\nThread ID:"+t12.threadId()+" Started");
        t12.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app12.setDone();
        t12.interrupt();

        System.out.println("\nThread ID:"+t13.threadId()+" Started");
        t13.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app13.setDone();
        t13.interrupt();

        System.out.println("\nThread ID:"+t14.threadId()+" Started");
        t14.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app14.setDone();
        t14.interrupt();

        System.out.println("\nThread ID:"+t15.threadId()+" Started");
        t15.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app15.setDone();
        t15.interrupt();
    }

}
