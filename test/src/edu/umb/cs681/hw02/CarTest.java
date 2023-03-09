package edu.umb.cs681.hw02;

import edu.umb.cs681.hw01.Car;
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

    @Test
    public void testAverageUsingClassInstance(){
        double averagePrice = CarsList.stream()
                .map(Car::getPrice)
                .reduce(new CarPriceResultHolder(), (result, price) -> {
                    int num = result.getNumCarExamined();
                    result.setAverage(((result.getAverage() * result.getNumCarExamined())+ price) / ++num);
                    result.setNumCarExamined(num++);
                    return result;
                },(finalR, intermediate) -> finalR).getAverage();

        System.out.println("Average: "+averagePrice);
        assertEquals(10800.0, averagePrice);
    }

}