package edu.umb.cs681.hw03;

public class Summary {

    Double open;
    Double close;
    Double high;
    Double low;

    public Summary(Double open, Double close, Double high, Double low) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }


}
