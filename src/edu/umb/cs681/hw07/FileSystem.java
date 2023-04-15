package edu.umb.cs681.hw07;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class FileSystem {

    private static FileSystem fileSystem = null; //Instance for singleton
    private LinkedList<Directory> RootDirs = new LinkedList<Directory>();

    private static ReentrantLock sLock = new ReentrantLock();



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

        return RootDirs;
    }

    public void appendRootDirs(Directory root){ //public method

        this.RootDirs.add(root);
    }



}
