package edu.umb.cs681.hw15;


public class DataHandler implements Runnable{

    public StockQuoteObservable obs = new StockQuoteObservable();
    Observer updateQuoteLineChart =  (sender, event) -> System.out.println("StockEvent LineChart Updated");
    Observer updateQuoteTableChart =  (sender, event) -> System.out.println("StockEvent Table Updated");
    Observer updateQuoteThreeDOChart =  (sender, event) -> System.out.println("StockEvent ThreeDO Updated");

    LineChartObserver lco = new LineChartObserver();
    TableObserver to = new TableObserver();
    ThreeDObserver tdo = new ThreeDObserver();




    @Override
    public void run() {
        obs.addObserver(updateQuoteLineChart);
        obs.addObserver(updateQuoteTableChart);
        obs.addObserver(updateQuoteThreeDOChart);
        obs.changeQuote("abc", 2222);
        obs.addObserver(lco);
        obs.addObserver(to);
        obs.addObserver(tdo);
        obs.changeQuote("xyz", 5463);
    }

    public static void main(String[] args) {

        for(int i = 0; i < 11; i++){
            new Thread(new DataHandler()).start();
        }


    }
}
