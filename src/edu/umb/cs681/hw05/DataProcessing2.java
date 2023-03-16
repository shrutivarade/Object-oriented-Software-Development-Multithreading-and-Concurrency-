package edu.umb.cs681.hw05;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessing2 implements Runnable{

    Housing hobj = new Housing();

    @Override
    public void run() {
        //Read/parse the CSV file and
        Path path = Paths.get("bos-housing.csv");
        List<List<String>> data = hobj.housingData(path);
//        data.forEach(System.out::println);

        // Data Processing #2
        //– Identify the areas/blocks within the top (lowest) 10% of “low” crime rate and the top (lowest) 10% of pupil-teacher ratio.
        System.out.println("\nIdentify the areas/blocks within the top (lowest) 10% of “low” crime rate and the top (lowest) 10% of pupil-teacher ratio.");
        List<List<String>> lowCrimeSorted = data.stream().sorted(Comparator.comparingDouble(h -> Double.parseDouble(h.get(0).replace("\"","")))).collect(Collectors.toList());
        double tenpercentCrime = (double) lowCrimeSorted.stream().count()*(0.1);
        List<List<String>> lowCrimeData = lowCrimeSorted.stream().limit((int)tenpercentCrime).collect(Collectors.toList());
//        System.out.println(lowCrimeData);

        List<List<String>> lowPTRSorted = lowCrimeData.stream().sorted(Comparator.comparingDouble(h -> Double.parseDouble(h.get(10).replace("\"","")))).collect(Collectors.toList());
        double tenpercentPTR = (double) lowPTRSorted.stream().count()*(0.1);
        List<List<String>> lowPTRData = lowPTRSorted.stream().limit((int)tenpercentPTR).collect(Collectors.toList());
//        System.out.println(lowPTRData);

        //– Compute the max, min and average of: • Price • NOX concentration • # of rooms
        System.out.println("Compute the max, min and average of: • Price • NOX concentration • # of rooms");
        DoubleSummaryStatistics summ_Price = lowPTRData.stream()
                .mapToDouble(h -> Double.parseDouble(h.get(13).replace("\"","")))
                .summaryStatistics();

        System.out.println("\nMin Price: $"+summ_Price.getMin()+" times $1000");
        System.out.println("Max Price: $"+summ_Price.getMax()+" times $1000");
        System.out.println("Avg Price: $"+summ_Price.getAverage()+" times $1000");

        DoubleSummaryStatistics summ_NOX = lowPTRData.stream()
                .mapToDouble(h -> Double.parseDouble(h.get(4).replace("\"","")))
                .summaryStatistics();

        System.out.println("\nMin NOX: "+summ_NOX.getMin()+" parts per 10 million");
        System.out.println("Max NOX: "+summ_NOX.getMax()+" parts per 10 million");
        System.out.println("Avg NOX: "+summ_NOX.getAverage()+" parts per 10 million");

        DoubleSummaryStatistics summ_rooms = lowPTRData.stream()
                .mapToDouble(h -> Double.parseDouble(h.get(5).replace("\"","")))
                .summaryStatistics();

        System.out.println("\nMin Rooms: "+(int)summ_rooms.getMin());
        System.out.println("Max Rooms: "+(int)summ_rooms.getMax());
        System.out.println("Avg Rooms: "+summ_rooms.getAverage());


    }
}
