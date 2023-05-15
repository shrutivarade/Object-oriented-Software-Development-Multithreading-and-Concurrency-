package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class Directory extends FSElement {

    public LinkedList<FSElement> children = new LinkedList<FSElement>();
    public LinkedList<Directory> SubDirectories = new LinkedList<>();
    public LinkedList<File> Files = new LinkedList<>();
    public int totalSize;
    protected ReentrantLock lock = new ReentrantLock();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) { //constructor
        super(parent, name, 0, creationTime);
    }

    public LinkedList<FSElement> getChildren() { //getter
        this.lock.lock();
        try{
            return this.children;
        }finally {
            this.lock.unlock();
        }
    }

    public LinkedList<Directory> getSubDirectories() { //getter
        this.lock.lock();
        try{
            for (FSElement fs : children) {
                if (fs.isDirectory()) {
                    SubDirectories.add((Directory) fs);
                }
            }
            return SubDirectories;
        }finally {
            this.lock.unlock();
        }
    }

    public LinkedList<File> getFiles() { //getter
        this.lock.lock();
        try{
            for (FSElement fs : children) {
                if (fs.isFile()) {
                    Files.add((File) fs);
                }
            }
            return Files;
        }finally {
            this.lock.unlock();
        }
    }

    public void appendChild(FSElement child){ //public method
        this.lock.lock();
        try{
            this.children.add(child);
        }finally {
            this.lock.unlock();
        }
    }

    public int countChildren(){ //public method
        this.lock.lock();
        try{
            return this.children.size();
        }finally {
            this.lock.unlock();
        }

    }

    public int getTotalSize() { //public method
        this.lock.lock();
        try{
            totalSize=0;
            for (FSElement fse : children) {
                if (fse.isDirectory()) {
                    totalSize = totalSize + ((Directory) fse).getTotalSize();
                } else {
                    totalSize = totalSize + fse.getSize();
                }
            }
            return totalSize;
        }finally {
            this.lock.unlock();
        }
    }

    @Override
    public boolean isDirectory() { //public method

        return true;
    }

    @Override
    public boolean isFile() { //public method

        return false;
    }

    @Override
    public boolean isLink() { //public method

        return false;
    }


}
