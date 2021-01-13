package com.example.java8.chapter8.ObserverPattern;

/**
 * 你可以声明不同的观察着，比如我们这里是三家不同报纸机构
 */
public class NYTimes implements IObserver {
    @Override
    public void notify(String tweet) {
        if(tweet != null){
            System.out.println("Breaking news in NY! "+ tweet);
        }
    }
}

class Guardian implements IObserver {
    @Override
    public void notify(String tweet) {
        if(tweet != null){
            System.out.println("Yet another news in London..."+ tweet);
        }
    }
}

class LeMonde implements IObserver {
    @Override
    public void notify(String tweet) {
        if(tweet != null){
            System.out.println("Today cheese ,wine and news! "+ tweet);
        }
    }
}
