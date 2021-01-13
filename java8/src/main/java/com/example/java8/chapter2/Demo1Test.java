package com.example.java8.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo1Test {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        Apple apple = new Apple();
        apple.setColor("红色");
        apple.setWeight(500.0);

        Apple apple1 = new Apple();
        apple1.setColor("绿色");
        apple1.setWeight(150.0);
        apples.add(apple);
        apples.add(apple1);
        //apples.stream().filter((Apple a) -> a.getColor().equals("红色")).collect(apples1);
//
//        System.out.println(apples);
//        System.out.println(apples1);



    }

}
