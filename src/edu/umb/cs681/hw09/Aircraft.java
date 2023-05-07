package edu.umb.cs681.hw09;

import java.util.concurrent.locks.ReentrantLock;

public class Aircraft {
    private Position position;
    private ReentrantLock lock = new ReentrantLock();
    public Aircraft(Position pos){
        this.position = pos;
    }

    public void setPosition(double newLat, double newLong, double newAlt){
        lock.lock();
        try{
            this.position = this.position.change(newLat, newLong, newAlt);
            System.out.println("Set Latitude:"+this.position.latitude());
            System.out.println("Set Longitude:"+this.position.longitude());
            System.out.println("Set Altitude:"+this.position.altitude());
        }
        finally {
            lock.unlock();
        }

    }
    public Position getPosition(){
        lock.lock();
        try{
            System.out.println("Get Latitude:"+this.position.latitude());
            System.out.println("Get Longitude:"+this.position.longitude());
            System.out.println("Get Altitude:"+this.position.altitude());
            return position;
        }
        finally {
            lock.unlock();
        }

    }
}
