package edu.umb.cs681.hw13;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AccessCounter {

    private static AccessCounter accesscounter = null;
    private HashMap<Path,Integer> files = new HashMap<>();
    private static ReentrantLock sLock = new ReentrantLock();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();


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
        rwLock.writeLock().lock();
        try {
            if (files.containsKey(path)) {
                files.put(path, files.get(path) + 1);
            } else {
                files.put(path, 1);
            }
        }
        finally {
            rwLock.writeLock().unlock();
        }
    }

    public int getCount(Path path) {

        rwLock.readLock().lock();
        try {
            if(files.containsKey(path)){
                return files.get(path);
            }
            else{
                return 0;
            }
        }
        finally {
            rwLock.readLock().unlock();
        }

    }


}
