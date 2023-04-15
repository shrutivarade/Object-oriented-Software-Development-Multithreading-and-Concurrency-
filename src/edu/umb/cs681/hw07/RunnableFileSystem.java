package edu.umb.cs681.hw07;

public class RunnableFileSystem implements Runnable{


    @Override
    public void run() {
        System.out.println(FileSystem.getFileSystem());
    }

    public static void main(String[] args) {
        RunnableFileSystem rfs = new RunnableFileSystem();

        Thread t1 = new Thread(rfs);
        Thread t2 = new Thread(rfs);
        Thread t3 = new Thread(rfs);
        Thread t4 = new Thread(rfs);
        Thread t5 = new Thread(rfs);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }

}
