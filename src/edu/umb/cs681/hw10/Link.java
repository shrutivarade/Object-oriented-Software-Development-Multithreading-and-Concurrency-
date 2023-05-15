package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class Link extends FSElement {

    private FSElement target;

    protected ReentrantLock lock = new ReentrantLock();

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
    }

    public FSElement getTarget() {
        this.lock.lock();
        try {
            return this.target;
        }finally{
            this.lock.unlock();
        }

    }

    public int TargetSize(){
        this.lock.lock();
        try {
            return this.target.getSize();
        }finally{
            this.lock.unlock();
        }

    }

    @Override
    public boolean isDirectory() {
        return false;
    }
    @Override
    public boolean isFile() {
        return false;
    }
    @Override
    public boolean isLink() {
        return true;
    }




}
