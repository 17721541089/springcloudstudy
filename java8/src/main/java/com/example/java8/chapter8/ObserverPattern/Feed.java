package com.example.java8.chapter8.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Feed implements ISubject {
    private final List<IObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(observer -> observer.notify(tweet));
    }

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("你好， 观察着模式");
    }
}
