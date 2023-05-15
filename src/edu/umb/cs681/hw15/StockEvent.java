//package edu.umb.cs681.hw15;
//
//public class StockEvent {
//
//    String ticker;
//    Double quote;
//
//    public StockEvent(String ticker, Double quote) {
//        this.ticker = ticker;
//        this.quote = quote;
//    }
//
//    public String getTicker() {
//        System.out.println(ticker);
//        return ticker;
//    }
//
//    public void setTicker(String ticker) {
//        this.ticker = ticker;
//    }
//
//    public Double getQuote() {
//        System.out.println(quote);
//        return quote;
//    }
//
//    public void setQuote(Double quote) {
//        this.quote = quote;
//    }
//}


package edu.umb.cs681.hw15;

public record StockEvent(String ticker, Double quote) {
}
