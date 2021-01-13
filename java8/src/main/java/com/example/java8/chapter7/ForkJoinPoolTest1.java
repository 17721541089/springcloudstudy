package com.example.java8.chapter7;

public class ForkJoinPoolTest1 {


    public static void main(String[] args) {
        long result  = ForkJoinSumCalculator.forkJoinSum(100000);
        System.out.println(result);
    }
}
