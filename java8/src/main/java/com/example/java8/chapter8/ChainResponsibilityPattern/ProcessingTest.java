package com.example.java8.chapter8.ChainResponsibilityPattern;

import com.alibaba.fastjson.JSONObject;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ProcessingTest {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckProcessing();
        p1.setSuccessor(p2);
        String result =p1.handle("Aren't labdas relly secy?!!");
        System.out.println(result);

        //使用Lambda Unary:一元
        UnaryOperator<String>  p3 = (String text) -> text + " ....";
        UnaryOperator<String>  p4 = (String text) -> text.replaceAll("？","??");
        Function<String,String> pipeLine = p3.andThen(p4);
        String result2 = pipeLine.apply("Aren't labdas relly secy?!!");
        System.out.println(result2);

        JSONObject jsonObject = new JSONObject();

    }
}
