package com.example.java8.chapter8.StrategyPattern;

/**
 * 具体策略类--乘坐高铁
 */
public class HighTrainStrategy implements TravelStrategy {
    @Override
    public void travelAlgorithm() {
        System.out.println("乘坐高铁。。。");
    }
}
