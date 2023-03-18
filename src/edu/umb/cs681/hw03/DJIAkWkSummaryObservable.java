package edu.umb.cs681.hw03;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DJIAkWkSummaryObservable extends Observable<WkSummary>{

    // Collection of DailySummary:
     public List<DSummary> dSumm = new LinkedList<DSummary>();

    // Add a daily summary to the collection.
    public void addSummary(DSummary dSummary){
        dSumm.add(dSummary);

//        dSumm.forEach(System.out::println);


        // If the collection has 5 data,
        //* Calculate a weekly summary
        //* Notify observers with it
        //* Clear the collection


        if(dSumm.size() == 5){

//            System.out.println(dSumm);

            WkSummary week = new WkSummary(
                    dSumm.get(4).getOpen(),
                    dSumm.get(0).getClose(),
                    dSumm.stream().map((DSummary d)-> d.getHigh()).max(Double::compare).get(),
                    dSumm.stream().map((DSummary d)-> d.getLow()).min(Double::compare).get());

//            System.out.println("\n"+week+"\n");

            notifyObservers(week);

            dSumm.clear();

//            System.out.println("\n"+week+"\n");
//            dSumm.forEach(System.out::println);

        }



    }


}
