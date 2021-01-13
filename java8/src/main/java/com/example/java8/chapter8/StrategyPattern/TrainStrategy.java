package com.example.java8.chapter8.StrategyPattern;

/**
 * 具体策略类--乘坐火车
 */
public class TrainStrategy implements TravelStrategy {
    @Override
    public void travelAlgorithm() {
        System.out.println("乘坐火车。。。");
    }
}