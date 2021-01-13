package com.example.java8.chapter8.ObserverPattern;

/**
 * 定义一个主题类接口
 */
public interface ISubject {
    //注册观察者
    void registerObserver(IObserver observer);
    //注销观察者
    void unregister(IObserver observer);
    //通知所有观察者
    void notifyObservers(String tweet);
}
