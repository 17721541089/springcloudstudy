package com.example.java8.chapter8.ChainResponsibilityPattern;

public class HeaderTextProcessing extends ProcessingObject<String>{
    @Override
    protected String handlerWork(String text) {
        return "From Raoul,Mario and Alan:"+text;
    }
}
