package edu.umb.cs681.hw14;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;

class EntranceHandler implements Runnable{
    private AdmissionMonitor monitor;

    public EntranceHandler(AdmissionMonitor monitor) {
        this.monitor = monitor;
    }

    private AtomicBoolean flagAtomic = new AtomicBoolean(true);
    public void setFlagAtomic() {
        flagAtomic.set(false);
    }


    @Override
    public void run() {
        while (flagAtomic.get()){
            monitor.enter();
        }

    }
}