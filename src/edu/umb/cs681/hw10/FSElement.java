package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
    public Directory parent;
    protected String name;
    protected int size; //Should be zero for a directory
    protected LocalDateTime creationTime;

    protected ReentrantLock lock = new ReentrantLock();

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent(){
        this.lock.lock();
        try{
            return this.parent;
        }finally {
            this.lock.unlock();
        }
    }
    public void setParent(Directory parent) {
        this.lock.lock();
        try{
            this.parent = parent;
        }finally {
            this.lock.unlock();
        }
    }


    public String getName() {
        this.lock.lock();
        try{
            return this.name;
        }finally {
            this.lock.unlock();
        }
    }
    public void setName(String name) {
        this.lock.lock();
        try{
            this.name = name;
        }finally {
            this.lock.unlock();
        }
    }


    public int getSize() {
        this.lock.lock();
        try{
            return this.size;
        }finally {
            this.lock.unlock();
        }
    }
    public void setSize(int size) {
        this.lock.lock();
        try{
            if(isDirectory()){
                this.size = 0;
            }
            else{
                this.size = size;
            }
        }finally {
            this.lock.unlock();
        }
    }


    public LocalDateTime getCreationTime() {
        return this.creationTime;

    }
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;

    }


    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isLink();

}
