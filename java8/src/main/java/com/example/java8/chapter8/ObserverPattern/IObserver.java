package com.example.java8.chapter8.ObserverPattern;

/**
 * 首先你需要一个观察者接口，它将不同的观察着聚合在一起。
 * 它仅有一个名为noyify的方法，一旦接收到一条新的新闻，该
 * 方法就会被调用
 * tweet：推特
 */
public interface IObserver {
    void notify(String tweet);
}
