package edu.umb.cs681.hw10;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class FileSystem {

    private static FileSystem fileSystem = null; //Instance for singleton
    private LinkedList<Directory> RootDirs = new LinkedList<Directory>();
    private static ReentrantLock sLock = new ReentrantLock();
    private ReentrantLock lock = new ReentrantLock();

    private FileSystem() { //private constructor
    }

    public static FileSystem getFileSystem() { //Static Factory Method

        sLock.lock();
        try{
            if(fileSystem == null)
                fileSystem = new FileSystem();
            return fileSystem;
        }
        finally {
            sLock.unlock();
        }


    }

    public LinkedList<Directory> getRootDirs() { //getter
        lock.lock();
        try{
            return RootDirs;
        }
        finally {
            lock.unlock();
        }

    }

    public void appendRootDirs(Directory root){ //public method
        lock.lock();
        try{
            this.RootDirs.add(root);
        }
        finally {
            lock.unlock();
        }

    }



}
