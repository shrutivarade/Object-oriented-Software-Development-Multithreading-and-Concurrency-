package edu.umb.cs681.hw19;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class StockQuoteObservable extends Observable<StockEvent> {

    HashMap<String, Double> hm = new HashMap<>();
    private ReentrantLock lockTQ = new ReentrantLock();

    public void changeQuote(String t, double q){
        lockTQ.lock();
        try{
            this.hm.put(t,q);
        }
        finally {
            lockTQ.unlock();
        }
        notifyObservers(new StockEvent(t,q));
        System.out.println("ChangeQuote Done: t-> "+t+" & q-> "+q);
    }


}
