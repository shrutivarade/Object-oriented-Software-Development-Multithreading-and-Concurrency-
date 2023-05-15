package edu.umb.cs681.hw07;

public class RunnableFileSystem implements Runnable{


    @Override
    public void run() {
        System.out.println("Hashcode for the filesystem instance: "+FileSystem.getFileSystem().hashCode());
    }

    public static void main(String[] args) {
        System.out.println("Singleton File System:\n");
        RunnableFileSystem rfs1 = new RunnableFileSystem();
        RunnableFileSystem rfs2 = new RunnableFileSystem();
        RunnableFileSystem rfs3 = new RunnableFileSystem();
        RunnableFileSystem rfs4 = new RunnableFileSystem();
        RunnableFileSystem rfs5 = new RunnableFileSystem();

        Thread t1 = new Thread(rfs1);
        Thread t2 = new Thread(rfs2);
        Thread t3 = new Thread(rfs3);
        Thread t4 = new Thread(rfs4);
        Thread t5 = new Thread(rfs5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }

}
