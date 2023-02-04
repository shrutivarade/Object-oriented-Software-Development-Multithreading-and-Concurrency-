package edu.umb.cs681.hw01;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Car> CarsList = new ArrayList<Car>();

        CarsList.add(new Car("Hyundai", "A7", 10,2023, 400000));
        CarsList.add(new Car("Mercedes","B65", 20,2022, 510000));
        CarsList.add(new Car("Ferrari","R44", 30,2021, 620000));
        CarsList.add(new Car("Honda","GT5", 40,2020, 730000));
        CarsList.add(new Car("Tesla", "Y", 50,2019, 800000));
        CarsList.add(new Car("Tesla", "X", 55,2018, 850000));
        CarsList.add(new Car("Jaguar","XJ", 60,2018, 910000));
        CarsList.add(new Car("BMW","X3", 70,2027, 1200000));
        CarsList.add(new Car("Volkswagen","Atlas", 80,2017, 3700000));

//Sorting Policy for Prices

        List<Car> sortPriceAsc = CarsList.stream()
                .sorted((Car car1,Car car2) -> (int) (car1.getPrice() - car2.getPrice()))
                .collect(Collectors.toList());
        List<Float> pricesSortAsc = CarsList.stream()
                .map((Car car)-> car.getPrice())
                .sorted((Float p1, Float p2) -> (int) (p1-p2))
                .collect(Collectors.toList());
        System.out.println("\nSort prices in ascending order:(Returns Object)");
        sortPriceAsc.forEach(System.out::println);
        System.out.println("\nSort prices in ascending order:(Returns Float)");
        pricesSortAsc.forEach(System.out::println);

        List<Car> sortPriceD = CarsList.stream()
                .sorted(Comparator.comparing((Car car)->car.getPrice(), Comparator.reverseOrder()))
                .collect(Collectors.toList());
        List<Float> pricesSortD = CarsList.stream()
                .map((Car car)-> car.getPrice())
                .sorted((Float p1, Float p2) -> (int) (p2-p1))
                .collect(Collectors.toList());
        System.out.println("\nSort prices in descending order:(Returns Object)");
        sortPriceD.forEach(System.out::println);
        System.out.println("\nSort prices in descending order:(Returns Float)");
        pricesSortD.forEach(System.out::println);

        Map<Boolean, List<Car>> highPrice = CarsList.stream()
                .collect(Collectors.partitioningBy((Car car) -> car.getPrice()>700000));
        System.out.println("\nPartitioning High priced cars having price > 700000 : "+highPrice);

        Map<Boolean, List<Car>> lowPrice = CarsList.stream()
                .collect(Collectors.partitioningBy((Car car) -> car.getPrice()<500000));
        System.out.println("\nPartitioning Low Priced Cars having price < 500000: "+lowPrice);

        Map<String, Double> groupavgPriceByMaker = CarsList.stream()
                .collect(Collectors.groupingBy((Car car) -> car.getMake(), Collectors.averagingDouble((Car car)-> car.getPrice())));
        System.out.println("\nAveraging Price for each car maker: "+groupavgPriceByMaker);

        Car minPrice = CarsList.stream()
                .min(Comparator.comparing((Car car)-> car.getPrice()))
                .get();
        System.out.println("\nMin Price Car Object: "+minPrice.getMake());

        Car maxPrice = CarsList.stream()
                .max(Comparator.comparing((Car car)-> car.getPrice()))
                .get();
        System.out.println("\nMax Price Car Object: "+maxPrice.getMake());

        long countPrice = CarsList.stream()
                .filter((Car car)-> car.getPrice()>600000)
                .count();

        System.out.println("\nNumber of cars having price > 600000: "+countPrice);





//Sorting Policy for Year

        List<Car> sortYearAsc = CarsList.stream()
                .sorted(Comparator.comparing(Car::getYear))
                .collect(Collectors.toList());
        List<Integer> yearSortAsc = CarsList.stream()
                .map((Car car)-> car.getYear())
                .sorted((Integer y1, Integer y2) -> (int) (y1-y2))
                .collect(Collectors.toList());

        System.out.println("\nSort year in ascending order:(Returns Object)");
        sortYearAsc.forEach(System.out::println);
        System.out.println("\nSort year in ascending order:(Returns Integer)");
        yearSortAsc.forEach(System.out::println);

        List<Car> sortYearD = CarsList.stream()
                .sorted(Comparator.comparing(Car::getYear, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        List<Integer> yearSortD = CarsList.stream()
                .map((Car car)-> car.getYear())
                .sorted((Integer y1, Integer y2) -> (int) (y2-y1))
                .collect(Collectors.toList());
        System.out.println("\nSort year in descending order:(Returns Object)");
        sortYearD.forEach(System.out::println);
        System.out.println("\nSort year in descending order:(Returns Integer)");
        yearSortD.forEach(System.out::println);

        Map<Boolean, List<Car>> highYear = CarsList.stream()
                .collect(Collectors.partitioningBy((Car car) -> car.getYear()>2020));
        System.out.println("\nPartitioning New cars having year > 2020 : "+highYear);

        Map<Boolean, List<Car>> lowYear = CarsList.stream()
                .collect(Collectors.partitioningBy((Car car) -> car.getYear()<=2020));
        System.out.println("\nPartitioning Older Cars having price <= 2020: "+lowYear);

//        Map<String, Double> GroupavgYearByMaker = CarsList.stream()
//                .collect(Collectors.groupingBy((Car car) -> car.getMake(), Collectors.averagingDouble((Car car)-> car.getYear())));
//        System.out.println("\nAveraging Year for each car maker: "+GroupavgYearByMaker);

        Car minYear = CarsList.stream()
                .min(Comparator.comparing((Car car)-> car.getYear()))
                .get();
        System.out.println("\nMin year Car Object: "+minYear.getMake());

        Car maxYear = CarsList.stream()
                .max(Comparator.comparing((Car car)-> car.getYear()))
                .get();
        System.out.println("\nMax year Car Object: "+maxYear.getMake());

        long countYear = CarsList.stream()
                .filter((Car car)-> car.getYear()>2020)
                .count();

        System.out.println("\nNumber of cars having year > 2020: "+countYear);



//Sorting Policy for Mileage

        List<Car> sortMileageAsc = CarsList.stream()
                .sorted(Comparator.comparing(Car::getMileage))
                .collect(Collectors.toList());
        List<Integer> mileageSortAsc = CarsList.stream()
                .map((Car car)-> car.getMileage())
                .sorted((Integer m1, Integer m2) -> (int) (m1-m2))
                .collect(Collectors.toList());

        System.out.println("\nSort Mileage in ascending order:(Returns Object)");
        sortMileageAsc.forEach(System.out::println);
        System.out.println("\nSort Mileage in ascending order:(Returns Integer)");
        mileageSortAsc.forEach(System.out::println);

        List<Car> sortMileageD = CarsList.stream()
                .sorted(Comparator.comparing(Car::getMileage, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        List<Integer> mileageSortD = CarsList.stream()
                .map((Car car)-> car.getMileage())
                .sorted((Integer m1, Integer m2) -> (int) (m2-m1))
                .collect(Collectors.toList());
        System.out.println("\nSort Mileage in descending order:(Returns Object)");
        sortMileageD.forEach(System.out::println);
        System.out.println("\nSort Mileage in descending order:(Returns Integer)");
        mileageSortD.forEach(System.out::println);

        Map<Boolean, List<Car>> highMileage = CarsList.stream()
                .collect(Collectors.partitioningBy((Car car) -> car.getMileage()>40));
        System.out.println("\nPartitioning High Mileage Cars having year > 40 : "+highMileage);

        Map<Boolean, List<Car>> lowMileage = CarsList.stream()
                .collect(Collectors.partitioningBy((Car car) -> car.getMileage()<=40));
        System.out.println("\nPartitioning Low Mileage Cars having price <= 40: "+lowMileage);

        Map<String, Double> groupAvgMilByMaker = CarsList.stream()
                .collect(Collectors.groupingBy((Car car) -> car.getMake(), Collectors.averagingDouble((Car car)-> car.getMileage())));
        System.out.println("\nAveraging Mileage for each car maker: "+groupAvgMilByMaker);

        Car minMil = CarsList.stream()
                .min(Comparator.comparing((Car car)-> car.getMileage()))
                .get();
        System.out.println("\nMin Mileage Car Object: "+minMil.getMake());

        Car maxMil = CarsList.stream()
                .max(Comparator.comparing((Car car)-> car.getMileage()))
                .get();
        System.out.println("\nMax Mileage Car Object: "+maxMil.getMake());

        long countMil = CarsList.stream()
                .filter((Car car)-> car.getYear()>40)
                .count();

        System.out.println("\nNumber of cars having Mileage > 40: "+countMil);


//Sorting Policy for Domination

        CarsList.forEach((Car car) -> {
            car.setDominationCount(CarsList);
        });

        List<Car> sortDomiA = CarsList.stream()
                .sorted(Comparator.comparingInt(Car::getDominationCount))
                .collect(Collectors.toList());
        List<Integer> domiSortA = CarsList.stream()
                .map((Car car)-> car.getDominationCount())
                .sorted((Integer d1, Integer d2) -> (int) (d1-d2))
                .collect(Collectors.toList());
        System.out.println("\nSort Domination in descending order:(Returns Object)");
        sortDomiA.forEach(System.out::println);
        System.out.println("\nSort Domination in descending order:(Returns Integer)");
        domiSortA.forEach(System.out::println);

        List<Car> sortDomiD = CarsList.stream()
                .sorted((Car car1, Car car2) -> car2.getDominationCount() - car1.getDominationCount())
                .collect(Collectors.toList());
        List<Integer> domiSortD = CarsList.stream()
                .map((Car car)-> car.getDominationCount())
                .sorted((Integer d1, Integer d2) -> (int) (d2-d1))
                .collect(Collectors.toList());
        System.out.println("\nSort Domination in descending order:(Returns Object)");
        sortDomiD.forEach(System.out::println);
        System.out.println("\nSort Domination in descending order:(Returns Integer)");
        domiSortD.forEach(System.out::println);













        /*Map<Boolean, List<Car>> Partition = CarsList.stream()
                .collect(Collectors.partitioningBy((Car car) -> car.getPrice()>700000));
        System.out.println("\n"+Partition);

        Map<String, List<Car>> GroupByMaker = CarsList.stream()
                .collect(Collectors.groupingBy((Car car) -> car.getMake()));
        System.out.println("\n"+GroupByMaker);

        Map<String, Double> GroupavgPriceByMaker = CarsList.stream()
                .collect(Collectors.groupingBy((Car car) -> car.getMake(), Collectors.averagingDouble((Car car)-> car.getPrice())));
        System.out.println("\n"+GroupavgPriceByMaker);*/


        /*//Using map for MAKE
        List<String> Price = CarsList.stream()
                .map((Car car)->car.getMake())
                .collect(Collectors.toList());
        Price.forEach(System.out::println);*/

        /*// Using map for Price
        List<Float> prices = CarsList.stream()
                .map((Car car)-> car.getPrice())
                .collect(Collectors.toList());
        prices.forEach(System.out::println);*/

        /*// Using mao and sort for Price
        List<Float> pricesSort = CarsList.stream()
                .map((Car car)-> car.getPrice())
                .sorted((Float p1, Float p2) -> (int) (p1-p2))
                .collect(Collectors.toList());
        pricesSort.forEach(System.out::println);*/



    }
}
