package edu.umb.cs681.hw03;

public class CandleStickObserver implements Observer<WkSummary>{

    double openPrice;
    double closePrice;
    double highPrice;
    double lowPrice;

    @Override
    public void update(Observable sender, WkSummary event) {
        //Print the 4 data of a weekly summary.

        this.openPrice = event.getOpen();
        this.closePrice = event.getClose();
        this.highPrice = event.getHigh();
        this.lowPrice = event.getLow();



        System.out.println("Open WKSummary Price: "+openPrice);
        System.out.println("Close WKSummary Price: "+closePrice);
        System.out.println("High WKSummary Price: "+highPrice);
        System.out.println("Low WKSummary Price: "+lowPrice);


    }
}
