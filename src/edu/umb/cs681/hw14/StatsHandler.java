package edu.umb.cs681.hw14;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;

class StatsHandler implements Runnable{
    private AdmissionMonitor monitor;
    public StatsHandler(AdmissionMonitor monitor) {
        this.monitor = monitor;
    }
    private AtomicBoolean flagAtomic = new AtomicBoolean(true);
    public void setFlagAtomic() {
        flagAtomic.set(false);
    }

    int count = 0;

    @Override
    public void run() {
        while(flagAtomic.get()){
            count = monitor.countCurrentVisitors();
            System.out.println("Current visitors stats: "+count);

        }
    }
}
