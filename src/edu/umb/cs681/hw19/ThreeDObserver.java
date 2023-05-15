package edu.umb.cs681.hw19;


public class ThreeDObserver implements Observer<StockEvent> {

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println("Observable: "+sender+" Events: "+event);
    }
}
