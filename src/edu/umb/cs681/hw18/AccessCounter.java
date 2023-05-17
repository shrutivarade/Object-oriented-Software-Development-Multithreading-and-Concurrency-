package edu.umb.cs681.hw18;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {

    private static AccessCounter accesscounter = null;
    private ConcurrentHashMap<Path, AtomicInteger> files = new ConcurrentHashMap<>();
    private static ReentrantLock sLock = new ReentrantLock();

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
        files.compute(path, (Path k, AtomicInteger v) -> {
            return v == null ? new AtomicInteger(1) : new AtomicInteger(v.incrementAndGet());
        });
    }



    public int getCount(Path path) {
        return files.compute(path, (Path k, AtomicInteger v) -> {
            return v == null ? new AtomicInteger(0) : new AtomicInteger(v.get());
        }).get();
    }


}
