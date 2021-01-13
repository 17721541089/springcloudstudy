package com.example.java8.chapter2;

import java.util.ArrayList;
import java.util.List;

public class ApplePredicateImpl{

    public static List<Apple> filterApples(List<Apple> appleList,IApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple:appleList) {
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
