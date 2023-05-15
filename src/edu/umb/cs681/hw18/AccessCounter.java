package edu.umb.cs681.hw18;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {

    private static AccessCounter accesscounter = null;
    private ConcurrentHashMap<Path,Integer> files = new ConcurrentHashMap<>();
    private static ReentrantLock sLock = new ReentrantLock();
//    private ReentrantLock lock = new ReentrantLock();

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
        if (files.containsKey(path)) {
            files.put(path, files.get(path) + 1);
        } else {
            files.put(path, 1);
        }
    }

    public int getCount(Path path) {
        if(files.containsKey(path)){
            return files.get(path);
        }
        else{
            return 0;
        }
    }


}
