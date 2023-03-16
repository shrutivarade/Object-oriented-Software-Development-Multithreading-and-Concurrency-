package edu.umb.cs681.hw05;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataProcessing4 implements Runnable{

    Housing hobj = new Housing();

    @Override
    public void run() {

        //Read/parse the CSV file and
        Path path = Paths.get("bos-housing.csv");

        List<List<String>> data = hobj.housingData(path);
//        data.forEach(System.out::println);

        // Data Processing #4

        // Partition the areas/blocks in low and high categories depending upon tax.
        System.out.println("\nPartition the areas/blocks in low and high categories depending upon tax.");
        Map<Boolean, List<List<String>>> lowTaxData = data.stream()
                .collect(Collectors.partitioningBy(h -> Double.parseDouble(h.get(9).replace("\"","")) < 666));
//        System.out.println(lowTaxData);

        // Compute the Summary statistics for low category data.
        System.out.println("Compute the Summary statistics for low category data.");
        DoubleSummaryStatistics tax = lowTaxData.get(true).stream()
                .mapToDouble(h -> Double.parseDouble(h.get(5).replace("\"","")))
                .summaryStatistics();

        System.out.println("\nLow Tax Count: "+tax.getCount());

    }
}
