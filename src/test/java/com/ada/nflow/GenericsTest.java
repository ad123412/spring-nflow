package com.ada.nflow;

import com.ada.nflow.annotation.Employee;
import com.ada.nflow.annotation.Fruit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GenericsTest {
    private List<Employee> employees;
    private List<Fruit> fruits;

    @BeforeEach
    public void init() {
        employees = new ArrayList<Employee>() {{
            add(new Employee("Rohit", "Kumar", 30));
            add(new Employee("Bikash", "Roy", 35));
            add(new Employee("Abhishek", "Das", 40));
            add(new Employee("Abhishek", "Das", 25));
            add(new Employee("Rakesh", "Sharma", 60));
        }};

        fruits = new ArrayList<Fruit>() {{
            add(new Fruit("Banana", "Yellow", 5));
            add(new Fruit("Apple", "Red", 10));
            add(new Fruit("Blackberry", "Black", 50));
            add(new Fruit("Black Currant", "Black", 100));
            add(new Fruit("Blueberry", "Purple", 30));
            add(new Fruit("Mango", "Yellow", 20));
        }};
    }

    @Test
    public void test1() {
        System.out.println("before sorting ....");
        System.out.println(employees);
        System.out.println("-----------------------------------------------");
        employees.sort(Comparator.comparing(Employee::getFirstName, (s1, s2) -> s2.compareTo(s1))
                .thenComparing(Employee::getLastName)
                .thenComparing(Employee::getAge, (s1, s2) -> s2 - s1));
        System.out.println("after sorting ....");
        System.out.println(employees);
    }

    @Test
    public void test2() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        Map<String, List<Fruit>> map = fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getColour, Collectors.toList()));
        System.out.println(map);
    }

    @Test
    public void test4() {
        fruits.stream()
                .map(Fruit::getCount)
                .forEach(System.out::println);
        System.out.println("Total = ");
        int totalFruits = fruits.stream()
                .collect(Collectors.summingInt(Fruit::getCount));
        System.out.println(totalFruits);
    }

    @Test
    public void test5() {

        Collector<Fruit, int[], Integer> collector = Collector.of(
                () -> new int[1],
                (result, fruit) -> {
                    result[0] += fruit.getCount();
                },
                (result1, result2) -> {
                    result1[0] += result2[0];
                    return result1;
                },
                result -> result[0],
                Collector.Characteristics.CONCURRENT
        );
        int fruitCount = fruits.stream().collect(collector);
        System.out.println(fruitCount);
    }
}
