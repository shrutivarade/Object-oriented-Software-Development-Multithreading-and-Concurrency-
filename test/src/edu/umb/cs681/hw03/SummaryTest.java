package src.edu.umb.cs681.hw03;

import edu.umb.cs681.hw03.CandleStickObserver;
import edu.umb.cs681.hw03.DJIAkWkSummaryObservable;
import edu.umb.cs681.hw03.DSummary;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class SummaryTest {



    public static List<List<Double>> csvsetup() throws IOException {
        Path path = Paths.get("HistoricalPrices.csv");

        Stream<String> lines = Files.lines(path);

        List<List<String>> csv = lines.map(line -> {
            return Stream.of(line.split(","))
                    .map(value -> value.substring(0, value.length())).collect(Collectors.toList());
        }).collect(Collectors.toList());

        csv.remove(0); // remove headers

//            csv.forEach(System.out::println);

        List<Double> open = csv.stream().map(h -> Double.parseDouble(h.get(1))).collect(Collectors.toList());
//            System.out.println("\n"+open);

        List<Double> close = csv.stream().map(h -> Double.parseDouble(h.get(4))).collect(Collectors.toList());
//            System.out.println("\n"+close);

        List<Double> high = csv.stream().map(h -> Double.parseDouble(h.get(2))).collect(Collectors.toList());
//            System.out.println("\n"+high);

        List<Double> low = csv.stream().map(h -> Double.parseDouble(h.get(3))).collect(Collectors.toList());
//            System.out.println("\n"+low);


        List<List<Double>> data = Arrays.asList(open,close,high,low);

        return data;
    }

    DJIAkWkSummaryObservable djiaObj = new DJIAkWkSummaryObservable();
    CandleStickObserver candleObj = new CandleStickObserver();


    @Test
    public void testWKsummary() throws IOException {

        List<List<Double>> data = csvsetup();
//        data.forEach(System.out::println);
//        System.out.println(data);

        djiaObj.addObserver(candleObj);

        DSummary day1 = new DSummary(data.get(0).get(0), data.get(1).get(0), data.get(2).get(0), data.get(3).get(0));
        DSummary day2 = new DSummary(data.get(0).get(1), data.get(1).get(1), data.get(2).get(1), data.get(3).get(1));
        DSummary day3 = new DSummary(data.get(0).get(2), data.get(1).get(2), data.get(2).get(2), data.get(3).get(2));
        DSummary day4 = new DSummary(data.get(0).get(3), data.get(1).get(3), data.get(2).get(3), data.get(3).get(3));
        DSummary day5 = new DSummary(data.get(0).get(4), data.get(1).get(4), data.get(2).get(4), data.get(3).get(4));

        djiaObj.addSummary(day1);
        djiaObj.addSummary(day2);
        djiaObj.addSummary(day3);
        djiaObj.addSummary(day4);
        djiaObj.addSummary(day5);



    }



}