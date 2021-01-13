package com.example.java8.chapter4;

import java.util.*;
import java.util.stream.Collectors;

public class TestDemo1 {
    public static void main(String[] args) {
        Tread t1 = new Tread("t1","bj");
        Tread t2 = new Tread("t2","nj");
        Tread t3 = new Tread("t3","dj");
        Tread t4 = new Tread("t4","xj");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(t4,2011,300),
                new Transaction(t1,2012,1000),
                new Transaction(t1,2011,400),
                new Transaction(t2,2012,710),
                new Transaction(t2,2012,700),
                new Transaction(t3,2012,950)
        );
        // 1、找出2011年发生的所有交易，并按照交易额排序（从低到高）

        List<Transaction> tr2011 =
                transactions.stream()
                        .filter(t ->t.getYear() == 2011)
                        .sorted(Comparator.comparingInt(Transaction::getValue))
                        .collect(Collectors.toList());


        Collections.reverse(tr2011); // 倒序排列
        System.out.println(tr2011);

        //
        Set<String> city =
                 transactions.stream().map(transaction -> transaction.getT().getCity())
                .collect(Collectors.toSet());
        System.out.println(city);
    }


}
