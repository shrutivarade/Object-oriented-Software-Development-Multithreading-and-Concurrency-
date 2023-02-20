package edu.umb.cs681.hw01;

import org.junit.jupiter.api.*;
import org.w3c.dom.ls.LSOutput;

import javax.sql.rowset.CachedRowSet;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTest {


    static ArrayList<Car> CarsList = new ArrayList<Car>();
    @BeforeAll
    static void setValues(){
        CarsList.add(new Car("Hyundai", "A7", 10,2023, 400000));
        CarsList.add(new Car("Mercedes","B65", 20,2022, 510000));
        CarsList.add(new Car("Ferrari","R44", 30,2021, 620000));
        CarsList.add(new Car("Honda","GT5", 40,2020, 730000));
        CarsList.add(new Car("Tesla", "Y", 50,2019, 800000));
        CarsList.add(new Car("Tesla", "X", 55,2018, 850000));
        CarsList.add(new Car("Jaguar","XJ", 60,2018, 910000));
        CarsList.add(new Car("BMW","X3", 70,2027, 1200000));
        CarsList.add(new Car("Volkswagen","Atlas", 80,2017, 3700000));
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

    @Test
    @Order(9)
    public void testCarBySeparatingHighPriceCars(){
        Map<Boolean, List<Car>> highPrice = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getPrice()>700000));
        System.out.println("\nPartitioning High priced cars having price > 700000 : "+highPrice);
    }

    @Test
    @Order(10)
    public void testCarBySeparatingLowPriceCars(){
        Map<Boolean, List<Car>> lowPrice = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getPrice()<500000));
        System.out.println("\nPartitioning Low Priced Cars having price < 500000: "+lowPrice);
    }

    @Test
    @Order(11)
    public void testCarBySeparatingNewCars(){
        Map<Boolean, List<Car>> newCars = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getYear()>2020));
        System.out.println("\nPartitioning New cars having year > 2020 : "+newCars);
    }

    @Test
    @Order(12)
    public void testCarBySeparatingOldCars(){
        Map<Boolean, List<Car>> oldCars = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getYear()<=2020));
        System.out.println("\nPartitioning Older Cars having year <= 2020: "+oldCars);
    }

    @Test
    @Order(13)
    public void testCarBySeparatingHighMileage(){
        Map<Boolean, List<Car>> highMileage = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getMileage()>40));
        System.out.println("\nPartitioning High Mileage Cars having mileage > 40 : "+highMileage);
    }

    @Test
    @Order(14)
    public void testCarBySeparatingLowMileage(){
        Map<Boolean, List<Car>> lowMileage = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getMileage()<=40));
        System.out.println("\nPartitioning Low Mileage Cars having mileage <= 40: "+lowMileage);
    }

    @Test
    @Order(15)
    public void testCarBySeparatingHighDomination(){
        Map<Boolean, List<Car>> highDom = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getDominationCount()>4));
        System.out.println("\nPartitioning High Domination cars having Domination > 700000 : "+highDom);
    }

    @Test
    @Order(16)
    public void testCarBySeparatingLowDomination(){
        Map<Boolean, List<Car>> lowDom = CarsList.stream().collect(Collectors.partitioningBy((Car car) -> car.getDominationCount()<=4));
        System.out.println("\nPartitioning Low Domination Cars having Domination < 500000: "+lowDom);
    }


    //Averaging the price of each group of cars Using groupingBy

    @Test
    @Order(17)
    public void testCarbyAveragingValues(){
        Map<String, Double> groupavgPriceByMaker = CarsList.stream()
                .collect(Collectors.groupingBy((Car car) -> car.getMake(), Collectors.averagingDouble((Car car)-> car.getPrice())));
        System.out.println("\nAveraging Price for each car maker: "+groupavgPriceByMaker);
    }

    //Min and Max Values for each sorting policy groups

    @Test
    @Order(18)
    public void testCarbyMinPrice(){
        Car minPrice = CarsList.stream().min(Comparator.comparing((Car car)-> car.getPrice())).get();
        System.out.println("\nMin Price Car "+minPrice.getMake()+" is "+minPrice.getPrice());
        assertEquals(400000.0, minPrice.getPrice());
    }

    @Test
    @Order(19)
    public void testCarbyMaxPrice(){
        Car maxPrice = CarsList.stream().max(Comparator.comparing((Car car)-> car.getPrice())).get();
        System.out.println("\nMax Price Car "+maxPrice.getMake()+" is "+maxPrice.getPrice());
        assertEquals(3700000.0, maxPrice.getPrice());
    }

    @Test
    @Order(20)
    public void testCarbyMinYear(){
        Car minYear = CarsList.stream().min(Comparator.comparing((Car car)-> car.getYear())).get();
        System.out.println("\nMin Year Car "+minYear.getMake()+" is "+minYear.getYear());
        assertEquals(2017, minYear.getYear());
    }

    @Test
    @Order(21)
    public void testCarbyMaxYear(){
        Car maxYear = CarsList.stream().max(Comparator.comparing((Car car)-> car.getYear())).get();
        System.out.println("\nMax Year Car "+maxYear.getMake()+" is "+maxYear.getYear());
        assertEquals(2027, maxYear.getYear());
    }

    @Test
    @Order(22)
    public void testCarbyMinMileage(){
        Car minMileage = CarsList.stream().min(Comparator.comparing((Car car)-> car.getMileage())).get();
        System.out.println("\nMin Mileage Car "+minMileage.getMake()+" is "+minMileage.getMileage());
        assertEquals(10,minMileage.getMileage());
    }

    @Test
    @Order(23)
    public void testCarbyMaxMileage(){
        Car maxMileage = CarsList.stream().max(Comparator.comparing((Car car)-> car.getMileage())).get();
        System.out.println("\nMax Price Car "+maxMileage.getMake()+" is "+maxMileage.getMileage());
        assertEquals(80,maxMileage.getMileage());
    }

    @Test
    @Order(24)
    public void testCarbyMinDomination(){
        Car minDom = CarsList.stream().min(Comparator.comparing((Car car)-> car.getDominationCount())).get();
        System.out.println("\nMin Domination Car "+minDom.getMake()+" is "+minDom.getDominationCount());
        assertEquals(0,minDom.getDominationCount());
    }

    @Test
    @Order(25)
    public void testCarbyMaxDomination(){
        Car maxDom = CarsList.stream().max(Comparator.comparing((Car car)-> car.getDominationCount())).get();
        System.out.println("\nMax Domination Car "+maxDom.getMake()+" is "+maxDom.getDominationCount());
        assertEquals(7,maxDom.getDominationCount());
    }


    //Using count() method for each sorting policy group

    @Test
    @Order(26)
    public void testCarbyCountingValuesForPrice(){
        long countPrice = CarsList.stream().filter((Car car)-> car.getPrice()>600000).count();
        System.out.println("\nNumber of cars having price > 600000: "+countPrice);
        assertEquals(7,countPrice);
    }
    @Test
    @Order(27)
    public void testCarbyCountingValuesForYear(){
        long countYear = CarsList.stream().filter((Car car)-> car.getYear()>2020).count();
        System.out.println("\nNumber of cars having year > 2020: "+countYear);
        assertEquals(4,countYear);
    }
    @Test
    @Order(28)
    public void testCarbyCountingValuesForMileage(){
        long countMileage = CarsList.stream().filter((Car car)-> car.getMileage()>40).count();
        System.out.println("\nNumber of cars having mileage > 40: "+countMileage);
        assertEquals(5,countMileage);
    }
    @Test
    @Order(29)
    public void testCarbyCountingValuesForDomination(){
        long countDom = CarsList.stream().filter((Car car)-> car.getDominationCount()>4).count();
        System.out.println("\nNumber of cars having domination > 4: "+countDom);
        assertEquals(3,countDom);
    }
}