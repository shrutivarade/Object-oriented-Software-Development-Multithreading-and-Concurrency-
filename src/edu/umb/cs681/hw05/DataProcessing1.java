package edu.umb.cs681.hw05;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessing1 implements Runnable{

    Housing hobj = new Housing();

    @Override
    public void run() {
        //Read/parse the CSV file and
        Path path = Paths.get("bos-housing.csv");
        List<List<String>> data = hobj.housingData(path);
//        data.forEach(System.out::println);

        // Data Processing #1
        //– Identify the areas/blocks next to Charles river.
        System.out.println("\nIdentify the areas/blocks next to Charles river.");
        List<String> medv = data.stream()
                .filter(h -> Integer.parseInt(h.get(3).replace("\"","")) == 1)
                .map(h -> (h.get(13).replace("\"","")))
                .collect(Collectors.toList());
//        System.out.println(medv);

        //– Compute the highest, lowest and average price of those houses.
        System.out.println("Compute the highest, lowest and average price of those houses.");
        DoubleSummaryStatistics summ_medv = medv.stream()
                .mapToDouble(h -> Double.parseDouble(h.replace("\"","")))
                .summaryStatistics();
        System.out.println("\nMin: $"+summ_medv.getMin()+" times $1000");
        System.out.println("Max: $"+summ_medv.getMax()+" times $1000");
        System.out.println("Avg: $"+summ_medv.getAverage()+" times $1000");
    }
}
