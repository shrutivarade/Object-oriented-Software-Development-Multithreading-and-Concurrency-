package edu.umb.cs681.hw11;

import edu.umb.cs681.hw10.File;
import edu.umb.cs681.hw10.FileSystem;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {

    private static AccessCounter accesscounter = null;
    private HashMap<java.nio.file.Path,Integer> files = new HashMap<>();
    private static ReentrantLock sLock = new ReentrantLock();
    private ReentrantLock lock = new ReentrantLock();

    private AccessCounter(){

    }

    public static AccessCounter getInstance() {
        sLock.lock();
        try{
            if(accesscounter == null)
                accesscounter = new AccessCounter();
            return accesscounter;
        }
        finally {
            sLock.unlock();
        }
    }

    public void increment (Path path){
        lock.lock();
        try {
            if (files.containsKey(path)) {
                files.put(path, files.get(path) + 1);
            } else {
                files.put(path, 1);
            }
        }
        finally {
            lock.unlock();
        }
    }

    public int getCount(Path path) {

        lock.lock();
        try {
            if(files.containsKey(path)){
                return files.get(path);
            }
            else{
                return 0;
            }
        }
        finally {
            lock.unlock();
        }

    }


}
