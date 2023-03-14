package edu.umb.cs681.hw04;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Housing {

    public static List<List<String>> housingData(Path path) {

        try(Stream<String> lines= Files.lines(path)){

            List<List<String>> matrix = lines.map(line -> {
                return Stream.of( line.split(",") )
                        .map(value->value.substring(0,value.length()))
                        .collect( Collectors.toList() );
            }).collect( Collectors.toList() );

            matrix.remove(0); // remove headers.
//            matrix.forEach(System.out::println);
            return matrix;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {


        //Read/parse the CSV file and
        Path path = Paths.get("bos-housing.csv");

        List<List<String>> data = housingData(path);
//        data.forEach(System.out::println);


        // Data Processing #1
        //– Identify the areas/blocks next to Charles river.
        System.out.println("\nIdentify the areas/blocks next to Charles river.");
        List<String> medv = data.stream()
                .filter(h -> Integer.parseInt(h.get(3).replace("\"","")) == 1)
                .map(h -> (h.get(13).replace("\"","")))
                .collect(Collectors.toList());
        System.out.println(medv);

        //– Compute the highest, lowest and average price of those houses.
        System.out.println("\nCompute the highest, lowest and average price of those houses.");
        DoubleSummaryStatistics summ_medv = medv.stream()
                .mapToDouble(h -> Double.parseDouble(h.replace("\"","")))
                .summaryStatistics();
        System.out.println("\nMin: $"+summ_medv.getMin()+" times $1000");
        System.out.println("Max: $"+summ_medv.getMax()+" times $1000");
        System.out.println("Avg: $"+summ_medv.getAverage()+" times $1000");


        // Data Processing #2
        //– Identify the areas/blocks within the top (lowest) 10% of “low” crime rate and the top (lowest) 10% of pupil-teacher ratio.
        System.out.println("\nIdentify the areas/blocks within the top (lowest) 10% of “low” crime rate and the top (lowest) 10% of pupil-teacher ratio.");
        List<List<String>> lowCrimeSorted = data.stream().sorted(Comparator.comparingDouble(h -> Double.parseDouble(h.get(0).replace("\"","")))).collect(Collectors.toList());
        double tenpercentCrime = (double) lowCrimeSorted.stream().count()*(0.1);
        List<List<String>> lowCrimeData = lowCrimeSorted.stream().limit((int)tenpercentCrime).collect(Collectors.toList());
        System.out.println(lowCrimeData);

        List<List<String>> lowPTRSorted = lowCrimeData.stream().sorted(Comparator.comparingDouble(h -> Double.parseDouble(h.get(10).replace("\"","")))).collect(Collectors.toList());
        double tenpercentPTR = (double) lowPTRSorted.stream().count()*(0.1);
        List<List<String>> lowPTRData = lowPTRSorted.stream().limit((int)tenpercentPTR).collect(Collectors.toList());
        System.out.println(lowPTRData);

        //– Compute the max, min and average of: • Price • NOX concentration • # of rooms
        System.out.println("\nCompute the max, min and average of: • Price • NOX concentration • # of rooms");
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

        // Data Processing #3

        //– Identify the areas/blocks within weighted distances less than 5 to five Boston employment centres.
        System.out.println("\nIdentify the areas/blocks within weighted distances less than 5 to five Boston employment centres.");
        List<String> dist = data.stream()
                .filter(h -> Double.parseDouble(h.get(7).replace("\"","")) < 5)
                .map(h -> (h.get(7).replace("\"","")))
                .collect(Collectors.toList());
        System.out.println(dist);

        //– Compute the count of those areas/blocks:
        System.out.println("\nCompute the count of those areas/blocks:");
        System.out.println(dist.stream().count());


        // Data Processing #4

        // Partition the areas/blocks in low and high categories depending upon tax.
        System.out.println("\nPartition the areas/blocks in low and high categories depending upon tax.");
        Map<Boolean, List<List<String>>> lowTaxData = data.stream()
                .collect(Collectors.partitioningBy(h -> Double.parseDouble(h.get(9).replace("\"","")) < 666));
        System.out.println(lowTaxData);

        // Compute the Summary statistics for low category data.
        System.out.println("\nCompute the Summary statistics for low category data.");
        DoubleSummaryStatistics tax = lowTaxData.get(true).stream()
                .mapToDouble(h -> Double.parseDouble(h.get(5).replace("\"","")))
                .summaryStatistics();

        System.out.println("\nLow Tax Count: "+tax.getCount());
    }
}
