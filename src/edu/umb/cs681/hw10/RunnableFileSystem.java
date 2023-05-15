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
        //do we need to have lock here?

        if(!done){
            fs = new TestFixture().createTextFixture();

            //FSElements methods
            System.out.println("\nFSElements methods");
            System.out.println("Parent of Apps: "+fs.getRootDirs().get(0).getChildren().get(1).getParent().getName());
            System.out.println("Time of d_link: "+fs.getRootDirs().get(0).getChildren().get(3).getCreationTime());
            System.out.println("Size of e_link: "+fs.getRootDirs().get(0).getChildren().get(4).getSize());

            //directory methods
            System.out.println("\nDirectory methods");
            System.out.println("Get files in directory Apps: "+fs.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0).getName());
            System.out.println("Children in home directory: "+fs.getRootDirs().get(0).getSubDirectories().get(2).getChildren().stream().map(t->t.getName()).collect(Collectors.toList()));
            System.out.println("Count Children in root Directory: "+fs.getRootDirs().get(0).countChildren());
            System.out.println("Get Total size of root: "+fs.getRootDirs().get(0).getTotalSize());

            //file methods
            System.out.println("\nFile  methods");
            System.out.println("is Apps a file, no: "+fs.getRootDirs().get(0).getSubDirectories().get(0).isFile());
            System.out.println("is d_link a Link, yes: "+fs.getRootDirs().get(0).getChildren().get(3).isLink());
            System.out.println("is Picture a directory, yes: "+fs.getRootDirs().get(0).getSubDirectories().get(2).getChildren().get(0).isDirectory());

            //link methods
            System.out.println("\nLink methods");
            System.out.println("Get target of link_d: "+new TestFixture().link_d.getTarget().getName());
            System.out.println("Size of target of link_e: "+new TestFixture().link_e.TargetSize());

            //filesystem methods
            System.out.println("Only 1 instance of filesystem: "+FileSystem.getFileSystem());

        }
    }


    @Override
    public void run() {
        callFSElements();
    }

    public static void main(String[] args) {

//        TestFixture tf = new TestFixture();
//        tf.createTextFixture();

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

        
        t1.start();
        System.out.println("\nThread ID:"+t1.threadId()+" Started");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        app1.setDone();
        t1.interrupt();
        System.out.println("\nThread ID:"+t1.threadId()+" Interrupted by 2 step termination process\n");

        
        t2.start();
        System.out.println("\nThread ID:"+t2.threadId()+" Started");
        app2.setDone();
        t2.interrupt();
        System.out.println("\nThread ID:"+t2.threadId()+" Interrupted by 2 step termination process\n");


        t3.start();
        System.out.println("\nThread ID:"+t3.threadId()+" Started");
        app3.setDone();
        t3.interrupt();
        System.out.println("\nThread ID:"+t3.threadId()+" Interrupted by 2 step termination process\n");


        t4.start();
        System.out.println("\nThread ID:"+t4.threadId()+" Started");
        app4.setDone();
        t4.interrupt();
        System.out.println("\nThread ID:"+t4.threadId()+" Interrupted by 2 step termination process\n");


        t5.start();
        System.out.println("\nThread ID:"+t5.threadId()+" Started");
        app5.setDone();
        t5.interrupt();
        System.out.println("\nThread ID:"+t5.threadId()+" Interrupted by 2 step termination process\n");


        t6.start();
        System.out.println("\nThread ID:"+t6.threadId()+" Started");
        app6.setDone();
        t6.interrupt();
        System.out.println("\nThread ID:"+t6.threadId()+" Interrupted by 2 step termination process\n");


        t7.start();
        System.out.println("\nThread ID:"+t7.threadId()+" Started");
        app7.setDone();
        t7.interrupt();
        System.out.println("\nThread ID:"+t7.threadId()+" Interrupted by 2 step termination process\n");


        t8.start();
        System.out.println("\nThread ID:"+t8.threadId()+" Started");
        app8.setDone();
        t8.interrupt();
        System.out.println("\nThread ID:"+t8.threadId()+" Interrupted by 2 step termination process\n");


        t9.start();
        System.out.println("\nThread ID:"+t9.threadId()+" Started");
        app9.setDone();
        t9.interrupt();
        System.out.println("\nThread ID:"+t9.threadId()+" Interrupted by 2 step termination process\n");


        t10.start();
        System.out.println("\nThread ID:"+t10.threadId()+" Started");
        app10.setDone();
        t10.interrupt();
        System.out.println("\nThread ID:"+t10.threadId()+" Interrupted by 2 step termination process\n");


        t11.start();
        System.out.println("\nThread ID:"+t11.threadId()+" Started");
        app11.setDone();
        t11.interrupt();
        System.out.println("\nThread ID:"+t11.threadId()+" Interrupted by 2 step termination process\n");


        t12.start();
        System.out.println("\nThread ID:"+t12.threadId()+" Started");
        app12.setDone();
        t12.interrupt();
        System.out.println("\nThread ID:"+t12.threadId()+" Interrupted by 2 step termination process\n");


        t13.start();
        System.out.println("\nThread ID:"+t13.threadId()+" Started");
        app13.setDone();
        t13.interrupt();
        System.out.println("\nThread ID:"+t13.threadId()+" Interrupted by 2 step termination process\n");


        t14.start();
        System.out.println("\nThread ID:"+t14.threadId()+" Started");
        app14.setDone();
        t14.interrupt();
        System.out.println("\nThread ID:"+t14.threadId()+" Interrupted by 2 step termination process\n");


        t15.start();
        System.out.println("\nThread ID:"+t15.threadId()+" Started");
        app15.setDone();
        t15.interrupt();
        System.out.println("\nThread ID:"+t15.threadId()+" Interrupted by 2 step termination process\n");


    }

}
