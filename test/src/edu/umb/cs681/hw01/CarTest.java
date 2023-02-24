package edu.umb.cs681.hw01;

import org.junit.jupiter.api.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTest {


    static ArrayList<Car> CarsList = new ArrayList<Car>();
    @BeforeAll
    static void setValues(){
        CarsList.add(new Car("Hyundai", "A7", 10,2023, 4000));
        CarsList.add(new Car("Mercedes","B65", 20,2022, 5100));
        CarsList.add(new Car("Ferrari","R44", 30,2021, 6200));
        CarsList.add(new Car("Honda","GT5", 40,2020, 7300));
        CarsList.add(new Car("Tesla_Y", "Y", 50,2019, 8000));
        CarsList.add(new Car("Tesla_X", "X", 55,2018, 8500));
        CarsList.add(new Car("Jaguar","XJ", 60,2018, 9100));
        CarsList.add(new Car("BMW","X3", 70,2027, 12000));
        CarsList.add(new Car("Volkswagen","Atlas", 80,2017, 37000));
    }

    //Price Sorting Policy

    @Test
    @Order(1)
    public void testSortingPolicyforPricesInAscendingOrder() {

        List<Car> sortAsc = CarsList.stream().sorted((Car car1, Car car2) -> (int) (car1.getPrice() - car2.getPrice())).collect(Collectors.toList());
        List<String> makeAsc = sortAsc.stream().map(Car::getMake).collect(Collectors.toList());
        List<Float> priceAsc = sortAsc.stream().map(Car::getPrice).collect(Collectors.toList());

        System.out.println("\nSort Prices in ascending order:");
        System.out.println(makeAsc);
        System.out.println(priceAsc);
    }

    @Test
    @Order(2)
    public void testSortingPolicyforPricesInDescendingOrder() {

        List<Car> sortDesc = CarsList.stream().sorted(Comparator.comparing((Car car) -> car.getPrice(), Comparator.reverseOrder())).collect(Collectors.toList());
        List<String> makeDesc = sortDesc.stream().map(Car::getMake).collect(Collectors.toList());
        List<Float> priceDesc = sortDesc.stream().map(Car::getPrice).collect(Collectors.toList());

        System.out.println("\nSort Prices in descending order:");
        System.out.println(makeDesc);
        System.out.println(priceDesc);
    }

    //Year Sorting Policy

    @Test
    @Order(3)
    public void testSortingPolicyforYearInAscendingOrder() {

        List<Car> sortAsc = CarsList.stream().sorted((Car car1, Car car2) -> (int) (car1.getYear() - car2.getYear())).collect(Collectors.toList());
        List<String> makeAsc = sortAsc.stream().map(Car::getMake).collect(Collectors.toList());
        List<Integer> yearAsc = sortAsc.stream().map(Car::getYear).collect(Collectors.toList());

        System.out.println("\nSort Year in ascending order:");
        System.out.println(makeAsc);
        System.out.println(yearAsc);
    }

    @Test
    @Order(4)
    public void testSortingPolicyforYearInDescendingOrder() {

        List<Car> sortDesc = CarsList.stream().sorted(Comparator.comparing((Car car) -> car.getYear(), Comparator.reverseOrder())).collect(Collectors.toList());
        List<String> makeDesc = sortDesc.stream().map(Car::getMake).collect(Collectors.toList());
        List<Integer> yearDesc = sortDesc.stream().map(Car::getYear).collect(Collectors.toList());

        System.out.println("\nSort Year in descending order:");
        System.out.println(makeDesc);
        System.out.println(yearDesc);
    }

    //Mileage Sorting Policy

    @Test
    @Order(5)
    public void testSortingPolicyforMileageInAscendingOrder() {

        List<Car> sortAsc = CarsList.stream().sorted((Car car1, Car car2) -> (int) (car1.getMileage() - car2.getMileage())).collect(Collectors.toList());
        List<String> makeAsc = sortAsc.stream().map(Car::getMake).collect(Collectors.toList());
        List<Integer> mileageAsc = sortAsc.stream().map(Car::getMileage).collect(Collectors.toList());

        System.out.println("\nSort Mileage in ascending order:");
        System.out.println(makeAsc);
        System.out.println(mileageAsc);
    }

    @Test
    @Order(6)
    public void testSortingPolicyforMileageInDescendingOrder() {

        List<Car> sortDesc = CarsList.stream().sorted(Comparator.comparing((Car car) -> car.getMileage(), Comparator.reverseOrder())).collect(Collectors.toList());
        List<String> makeDesc = sortDesc.stream().map(Car::getMake).collect(Collectors.toList());
        List<Integer> mileageDesc = sortDesc.stream().map(Car::getMileage).collect(Collectors.toList());

        System.out.println("\nSort Mileage in descending order:");
        System.out.println(makeDesc);
        System.out.println(mileageDesc);
    }

    //Domination Sorting Policy

    @Test
    @Order(7)
    public void testSortingPolicyforDominationInAscendingOrder() {

        CarsList.forEach((Car car) -> {
            car.setDominationCount(CarsList);
        });

        List<Car> sortAsc = CarsList.stream().sorted(Comparator.comparingInt(Car::getDominationCount)).collect(Collectors.toList());
        List<String> makeAsc = sortAsc.stream().map(Car::getMake).collect(Collectors.toList());
        List<Integer> domAsc = sortAsc.stream().map(Car::getDominationCount).collect(Collectors.toList());

        System.out.println("\nSort Domination in ascending order:");
        System.out.println(makeAsc);
        System.out.println(domAsc);
    }

    @Test
    @Order(8)
    public void testSortingPolicyforDominationInDescendingOrder() {

        CarsList.forEach((Car car) -> {
            car.setDominationCount(CarsList);
        });

        List<Car> sortDesc = CarsList.stream().sorted((Car car1, Car car2) -> car2.getDominationCount() - car1.getDominationCount()).collect(Collectors.toList());
        List<String> makeDesc = sortDesc.stream().map(Car::getMake).collect(Collectors.toList());
        List<Integer> domDesc = sortDesc.stream().map(Car::getDominationCount).collect(Collectors.toList());

        System.out.println("\nSort Domination in descending order:");
        System.out.println(makeDesc);
        System.out.println(domDesc);
    }



    //Partitioning for all policies


    //Partition Cars based on price
    @Test
    @Order(9)
    public void testCarByPartitioningBasedOnPrice(){

        Map<Boolean, List<Car>> partitionBasedOnPrices = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getPrice()>7500));

        List<String> highPricedCars = partitionBasedOnPrices.get(true).stream().map(Car::getMake).collect(Collectors.toList());
        System.out.println("\nHigh prices cars having price more than $7500: "+highPricedCars);
//        partitionBasedOnPrices.get(true).stream().map(Car::getMake).forEach(System.out::println);

        DoubleSummaryStatistics summaryForHighPricedCars = partitionBasedOnPrices.get(true).stream().mapToDouble(Car::getPrice).summaryStatistics();

        System.out.println("Minimum value for high priced cars: $"+summaryForHighPricedCars.getMin());
        System.out.println("Maximum value for high priced cars: $"+summaryForHighPricedCars.getMax());
        System.out.println("Average value for high priced cars: $"+summaryForHighPricedCars.getAverage());
        System.out.println("No of for high priced cars: "+summaryForHighPricedCars.getCount());

        assertEquals(8000.0,summaryForHighPricedCars.getMin());
        assertEquals(37000.0,summaryForHighPricedCars.getMax());
        assertEquals(14920.0, summaryForHighPricedCars.getAverage());
        assertEquals(5,summaryForHighPricedCars.getCount());


        List<String> lowPricedCars = partitionBasedOnPrices.get(false).stream().map(Car::getMake).collect(Collectors.toList());
        System.out.println("\nLow prices cars having price less than $7500: "+lowPricedCars);
//        partitionBasedOnPrices.get(false).stream().map(Car::getMake).forEach(System.out::println);

        DoubleSummaryStatistics summaryForLowPricedCars = partitionBasedOnPrices.get(false).stream().mapToDouble(Car::getPrice).summaryStatistics();

        System.out.println("Minimum value for low priced cars: $"+summaryForLowPricedCars.getMin());
        System.out.println("Maximum value for low priced cars: $"+summaryForLowPricedCars.getMax());
        System.out.println("Average value for low priced cars: $"+summaryForLowPricedCars.getAverage());
        System.out.println("No of for low priced cars: "+summaryForLowPricedCars.getCount());

        assertEquals(8000.0,summaryForHighPricedCars.getMin());
        assertEquals(37000.0,summaryForHighPricedCars.getMax());
        assertEquals(14920.0, summaryForHighPricedCars.getAverage());
        assertEquals(5,summaryForHighPricedCars.getCount());

    }


    //Partition Cars based on year
    @Test
    @Order(10)
    public void testCarByPartitioningBasedOnYear(){

        Map<Boolean, List<Car>> partitionBasedOnYear = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getYear()>2020));

        List<String> highYearCars = partitionBasedOnYear.get(true).stream().map(Car::getMake).collect(Collectors.toList());
        System.out.println("\nHigh year cars having value more than 2020: "+highYearCars);

        IntSummaryStatistics summaryForHighYearCars = partitionBasedOnYear.get(true).stream().mapToInt(Car::getYear).summaryStatistics();

        System.out.println("Minimum value for high year cars: "+summaryForHighYearCars.getMin());
        System.out.println("Maximum value for high year cars: "+summaryForHighYearCars.getMax());
        System.out.println("Average value for high year cars: "+(int)summaryForHighYearCars.getAverage());
        System.out.println("No of for high year cars: "+summaryForHighYearCars.getCount());

        assertEquals(2021,summaryForHighYearCars.getMin());
        assertEquals(2027,summaryForHighYearCars.getMax());
        assertEquals(2023, (int)summaryForHighYearCars.getAverage());
        assertEquals(4,summaryForHighYearCars.getCount());


        List<String> lowYearCars = partitionBasedOnYear.get(false).stream().map(Car::getMake).collect(Collectors.toList());
        System.out.println("\nLow year cars having value less than 2020: "+lowYearCars);

        IntSummaryStatistics summaryForLowYearCars = partitionBasedOnYear.get(false).stream().mapToInt(Car::getYear).summaryStatistics();

        System.out.println("Minimum value for low year cars: $"+summaryForLowYearCars.getMin());
        System.out.println("Maximum value for low year cars: $"+summaryForLowYearCars.getMax());
        System.out.println("Average value for low year cars: $"+(int)summaryForLowYearCars.getAverage());
        System.out.println("No of for low year cars: "+summaryForLowYearCars.getCount());

        assertEquals(2017,summaryForLowYearCars.getMin());
        assertEquals(2020,summaryForLowYearCars.getMax());
        assertEquals(2018, (int)summaryForLowYearCars.getAverage());
        assertEquals(5,summaryForLowYearCars.getCount());

    }


    //Partition Cars based on mileage
    @Test
    @Order(11)
    public void testCarByPartitioningBasedOnMileage(){

        Map<Boolean, List<Car>> partitionBasedOnMileage = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getMileage()>40));

        List<String> highMileageCars = partitionBasedOnMileage.get(true).stream().map(Car::getMake).collect(Collectors.toList());
        System.out.println("\nHigh Mileage cars having Mileage more than 40: "+highMileageCars);

        DoubleSummaryStatistics summaryForHighMileageCars = partitionBasedOnMileage.get(true).stream().mapToDouble(Car::getMileage).summaryStatistics();

        System.out.println("Minimum value for high Mileage cars: "+summaryForHighMileageCars.getMin());
        System.out.println("Maximum value for high Mileage cars: "+summaryForHighMileageCars.getMax());
        System.out.println("Average value for high Mileage cars: "+summaryForHighMileageCars.getAverage());
        System.out.println("No of for high Mileage cars: "+summaryForHighMileageCars.getCount());

        assertEquals(50.0,summaryForHighMileageCars.getMin());
        assertEquals(80.0,summaryForHighMileageCars.getMax());
        assertEquals(63.0, summaryForHighMileageCars.getAverage());
        assertEquals(5,summaryForHighMileageCars.getCount());


        List<String> lowMileageCars = partitionBasedOnMileage.get(false).stream().map(Car::getMake).collect(Collectors.toList());
        System.out.println("\nLow Mileage cars having Mileage less than 40: "+lowMileageCars);

        DoubleSummaryStatistics summaryForLowMileageCars = partitionBasedOnMileage.get(false).stream().mapToDouble(Car::getMileage).summaryStatistics();

        System.out.println("Minimum value for low Mileage cars: "+summaryForLowMileageCars.getMin());
        System.out.println("Maximum value for low Mileage cars: "+summaryForLowMileageCars.getMax());
        System.out.println("Average value for low Mileage cars: "+summaryForLowMileageCars.getAverage());
        System.out.println("No of for low Mileage cars: "+summaryForLowMileageCars.getCount());

        assertEquals(10.0,summaryForLowMileageCars.getMin());
        assertEquals(40.0,summaryForLowMileageCars.getMax());
        assertEquals(25.0, summaryForLowMileageCars.getAverage());
        assertEquals(4,summaryForLowMileageCars.getCount());

    }


    //Partition Cars based on price
    @Test
    @Order(12)
    public void testCarByPartitioningBasedOnDomination(){

        CarsList.forEach((Car car) -> {
            car.setDominationCount(CarsList);
        });

        Map<Boolean, List<Car>> partitionBasedOnDomination = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getDominationCount()>4));

        List<String> highDominationCars = partitionBasedOnDomination.get(true).stream().map(Car::getMake).collect(Collectors.toList());
        System.out.println("\nHigh prices cars having value more than 4: "+highDominationCars);
//        partitionBasedOnPrices.get(true).stream().map(Car::getMake).forEach(System.out::println);

        IntSummaryStatistics summaryForHighDominationCars = partitionBasedOnDomination.get(true).stream().mapToInt(Car::getDominationCount).summaryStatistics();

        System.out.println("Minimum value for high Domination cars: "+summaryForHighDominationCars.getMin());
        System.out.println("Maximum value for high Domination cars: "+summaryForHighDominationCars.getMax());
        System.out.println("Average value for high Domination cars: "+(int)summaryForHighDominationCars.getAverage());
        System.out.println("No of for high Domination cars: "+summaryForHighDominationCars.getCount());

        assertEquals(5,summaryForHighDominationCars.getMin());
        assertEquals(7,summaryForHighDominationCars.getMax());
        assertEquals(6, (int)summaryForHighDominationCars.getAverage());
        assertEquals(3,summaryForHighDominationCars.getCount());


        List<String> lowDominationCars = partitionBasedOnDomination.get(false).stream().map(Car::getMake).collect(Collectors.toList());
        System.out.println("\nLow Domination cars having Domination less than 4: "+lowDominationCars);
//        partitionBasedOnPrices.get(false).stream().map(Car::getMake).forEach(System.out::println);

        IntSummaryStatistics summaryForLowDominationCars = partitionBasedOnDomination.get(false).stream().mapToInt(Car::getDominationCount).summaryStatistics();

        System.out.println("Minimum value for low Domination cars: "+summaryForLowDominationCars.getMin());
        System.out.println("Maximum value for low Domination cars: "+summaryForLowDominationCars.getMax());
        System.out.println("Average value for low Domination cars: "+(int)summaryForLowDominationCars.getAverage());
        System.out.println("No of for low Domination cars: "+summaryForLowDominationCars.getCount());

        assertEquals(0,summaryForLowDominationCars.getMin());
        assertEquals(4,summaryForLowDominationCars.getMax());
        assertEquals(1, (int)summaryForLowDominationCars.getAverage());
        assertEquals(6,summaryForLowDominationCars.getCount());

    }

    //Averaging the price of each group of cars Using groupingBy

    @Test
    @Order(13)
    public void testCarbyAveragingValues(){
        Map<String, Double> groupavgPriceByMaker = CarsList.stream()
                .collect(Collectors.groupingBy((Car car) -> car.getMake(), Collectors.averagingDouble((Car car)-> car.getPrice())));
        System.out.println("\nAveraging Price for each car maker: "+groupavgPriceByMaker);
    }

    //Min and Max Values for each sorting policy groups

    @Test
    @Order(14)
    public void testCarbyMinPrice(){
        Car minPrice = CarsList.stream().min(Comparator.comparing((Car car)-> car.getPrice())).get();
        System.out.println("\nMin Price Car "+minPrice.getMake()+" is "+minPrice.getPrice());
        assertEquals(4000.0, minPrice.getPrice());
    }

    @Test
    @Order(15)
    public void testCarbyMaxPrice(){
        Car maxPrice = CarsList.stream().max(Comparator.comparing((Car car)-> car.getPrice())).get();
        System.out.println("\nMax Price Car "+maxPrice.getMake()+" is "+maxPrice.getPrice());
        assertEquals(37000.0, maxPrice.getPrice());
    }

    @Test
    @Order(16)
    public void testCarbyMinYear(){
        Car minYear = CarsList.stream().min(Comparator.comparing((Car car)-> car.getYear())).get();
        System.out.println("\nMin Year Car "+minYear.getMake()+" is "+minYear.getYear());
        assertEquals(2017, minYear.getYear());
    }

    @Test
    @Order(17)
    public void testCarbyMaxYear(){
        Car maxYear = CarsList.stream().max(Comparator.comparing((Car car)-> car.getYear())).get();
        System.out.println("\nMax Year Car "+maxYear.getMake()+" is "+maxYear.getYear());
        assertEquals(2027, maxYear.getYear());
    }

    @Test
    @Order(18)
    public void testCarbyMinMileage(){
        Car minMileage = CarsList.stream().min(Comparator.comparing((Car car)-> car.getMileage())).get();
        System.out.println("\nMin Mileage Car "+minMileage.getMake()+" is "+minMileage.getMileage());
        assertEquals(10,minMileage.getMileage());
    }

    @Test
    @Order(19)
    public void testCarbyMaxMileage(){
        Car maxMileage = CarsList.stream().max(Comparator.comparing((Car car)-> car.getMileage())).get();
        System.out.println("\nMax Price Car "+maxMileage.getMake()+" is "+maxMileage.getMileage());
        assertEquals(80,maxMileage.getMileage());
    }

    @Test
    @Order(20)
    public void testCarbyMinDomination(){
        Car minDom = CarsList.stream().min(Comparator.comparing((Car car)-> car.getDominationCount())).get();
        System.out.println("\nMin Domination Car "+minDom.getMake()+" is "+minDom.getDominationCount());
        assertEquals(0,minDom.getDominationCount());
    }

    @Test
    @Order(21)
    public void testCarbyMaxDomination(){
        Car maxDom = CarsList.stream().max(Comparator.comparing((Car car)-> car.getDominationCount())).get();
        System.out.println("\nMax Domination Car "+maxDom.getMake()+" is "+maxDom.getDominationCount());
        assertEquals(7,maxDom.getDominationCount());
    }


    //Using count() method for each sorting policy group

    @Test
    @Order(22)
    public void testCarbyCountingValuesForPrice(){
        long countPrice = CarsList.stream().filter((Car car)-> car.getPrice()>6000).count();
        System.out.println("\nNumber of cars having price > 6000: "+countPrice);
        assertEquals(7,countPrice);
    }
    @Test
    @Order(23)
    public void testCarbyCountingValuesForYear(){
        long countYear = CarsList.stream().filter((Car car)-> car.getYear()>2020).count();
        System.out.println("\nNumber of cars having year > 2020: "+countYear);
        assertEquals(4,countYear);
    }
    @Test
    @Order(24)
    public void testCarbyCountingValuesForMileage(){
        long countMileage = CarsList.stream().filter((Car car)-> car.getMileage()>40).count();
        System.out.println("\nNumber of cars having mileage > 40: "+countMileage);
        assertEquals(5,countMileage);
    }
    @Test
    @Order(25)
    public void testCarbyCountingValuesForDomination(){
        long countDom = CarsList.stream().filter((Car car)-> car.getDominationCount()>4).count();
        System.out.println("\nNumber of cars having domination > 4: "+countDom);
        assertEquals(3,countDom);
    }
}