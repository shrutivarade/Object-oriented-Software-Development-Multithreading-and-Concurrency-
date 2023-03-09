package edu.umb.cs681.hw02;

public class CarPriceResultHolder {

    private int numCarExamined;
    private double average;

    /*public CarPriceResultHolder(int numCarExamined, double average) {
        this.numCarExamined = numCarExamined;
        this.average = average;
    }*/

    public int getNumCarExamined() {
        return numCarExamined;
    }

    public void setNumCarExamined(int numCarExamined) {
        this.numCarExamined = numCarExamined;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
