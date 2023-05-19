package edu.umb.cs681.hw17.unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Spotify {
    protected List<String> playlist = new ArrayList<>();
    public int currentIndex = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void play() {
        lock.readLock().lock();
        try {
            System.out.println("Thread " + Thread.currentThread() + " playing: " + playlist.get(currentIndex));
        } finally {
            lock.readLock().unlock();
        }
    }

    public void pause() {
        lock.readLock().lock();
        try {
            System.out.println("Thread " + Thread.currentThread() + " pausing: " + playlist.get(currentIndex));
        } finally {
            lock.readLock().unlock();
        }
    }

    public void next() {
        lock.writeLock().lock();
        try {
            while(currentIndex>=playlist.size()-1){
                System.out.println("Waiting for playlist to get reset...");
            }
            currentIndex++;
            System.out.println("Thread " + Thread.currentThread() + " next: " + playlist.get(currentIndex));
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void previous() {
        lock.writeLock().lock();
        try {
            if (currentIndex > 0) {
                currentIndex--;
            }
            System.out.println("Thread " + Thread.currentThread() + " previous: " + playlist.get(currentIndex));
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String get() {
        lock.readLock().lock();
        try {
            return playlist.get(currentIndex);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setPlaylist(List<String> playlist) {
        lock.writeLock().lock();
        try {
            this.playlist = playlist;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void reset() {
        lock.writeLock().lock();
        try{
            if(currentIndex >= playlist.size()-1){
                System.out.println("Resetting currentIndex to 0");
                currentIndex = 0;
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

}