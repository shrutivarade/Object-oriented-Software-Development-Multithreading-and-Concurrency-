package edu.umb.cs681.hw14;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;

class ExitHandler implements Runnable{
    private AdmissionMonitor monitor;
    public ExitHandler(AdmissionMonitor monitor) {
        this.monitor = monitor;
    }
    private AtomicBoolean flagAtomic = new AtomicBoolean(false);
    public void setFlagAtomic() {
        flagAtomic.set(true);
    }

    @Override
    public void run() {
        while (true){
            try{
                if(flagAtomic.get()){
                    System.out.println(Thread.currentThread().threadId()+" : "+"Stop Accessing AdmissionMonitor by flag based termination");
                    break;
                }
                monitor.exit();
                Thread.sleep(Duration.ofSeconds(1));
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }
}
