package com.example.java8.chapter8.StrategyPattern;

/**
 * 环境类实现
 */
public class TravelStrategyEnvironment {
    //出行策略接口
    final TravelStrategy travelStrategy;
    //设置出行策略
    public TravelStrategyEnvironment(TravelStrategy travelStrategy){
        this.travelStrategy = travelStrategy;
    }
    //为当前用户设置出行方式
    public void travelStyle(){
        travelStrategy.travelAlgorithm();
    }

    public static void main(String[] args) {
        TravelStrategyEnvironment travelStrategyEnvironment = new TravelStrategyEnvironment(new HighTrainStrategy());
        TravelStrategyEnvironment travelStrategyEnvironment1 = new TravelStrategyEnvironment(new AirStrategy());
        travelStrategyEnvironment.travelStyle();
        travelStrategyEnvironment1.travelStyle();
        //使用Lambda表达式
        TravelStrategyEnvironment travelStrategyEnvironment2 = new TravelStrategyEnvironment(()-> System.out.println("乘坐轮船。。。"));
        travelStrategyEnvironment2.travelStyle();
    }
}
