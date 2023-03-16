package edu.umb.cs681.hw05;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessing3 implements Runnable{

    Housing hobj = new Housing();

    @Override
    public void run() {
        //Read/parse the CSV file and
        Path path = Paths.get("bos-housing.csv");
        List<List<String>> data = hobj.housingData(path);
//        data.forEach(System.out::println);

        // Data Processing #3

        //– Identify the areas/blocks within weighted distances less than 5 to five Boston employment centres.
        System.out.println("\nIdentify the areas/blocks within weighted distances less than 5 to five Boston employment centres.");
        List<String> dist = data.stream()
                .filter(h -> Double.parseDouble(h.get(7).replace("\"","")) < 5)
                .map(h -> (h.get(7).replace("\"","")))
                .collect(Collectors.toList());
//        System.out.println(dist);

        //– Compute the count of those areas/blocks:
        System.out.println("Compute the count of those areas/blocks:");
        System.out.println("\nCount:"+dist.stream().count());


    }
}
