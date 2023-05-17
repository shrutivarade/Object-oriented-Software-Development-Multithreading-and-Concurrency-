package edu.umb.cs681.hw14;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;

class StatsHandler implements Runnable{
    private AdmissionMonitor monitor;
    public StatsHandler(AdmissionMonitor monitor) {
        this.monitor = monitor;
    }
    private AtomicBoolean flagAtomic = new AtomicBoolean(false);
    public void setFlagAtomic() {
        flagAtomic.set(true);
    }

    int count = 0;

    @Override
    public void run() {
        while (true){
            try{
                if(flagAtomic.get()){
                    System.out.println(Thread.currentThread().threadId()+" : "+"Stop Accessing AdmissionMonitor by flag based termination");
                    break;
                }
                count = monitor.countCurrentVisitors();
                System.out.println("Current visitors stats: "+count);
                Thread.sleep(Duration.ofSeconds(1));
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }
}
