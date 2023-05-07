package edu.umb.cs681.hw05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static void main(String[] args) throws InterruptedException {
        DataProcessing1 dp1 = new DataProcessing1();
        DataProcessing2 dp2 = new DataProcessing2();
        DataProcessing3 dp3 = new DataProcessing3();
        DataProcessing4 dp4 = new DataProcessing4();

        Thread t1 = new Thread(dp1);
        Thread t2 = new Thread(dp2);
        Thread t3 = new Thread(dp3);
        Thread t4 = new Thread(dp4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        /*try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        }catch (InterruptedException e){}*/

    }
}
