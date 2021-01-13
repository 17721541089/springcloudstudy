package com.example.java8.chapter4;

import lombok.Data;

@Data
public class Transaction {
    private final Tread t;
    private final int year;
    private final int value;
}
