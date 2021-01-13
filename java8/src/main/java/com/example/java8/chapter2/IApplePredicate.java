package com.example.java8.chapter2;

public interface IApplePredicate {
    /**
     *行为参数化
     * 标准模型，根据Apple的某些属性，来返回一个boolean
     */
    boolean test(Apple apple);
}
