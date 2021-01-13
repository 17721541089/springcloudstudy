package com.example.java8.chapter8.ChainResponsibilityPattern;

public class SpellCheckProcessing extends ProcessingObject<String> {

    @Override
    protected String handlerWork(String text) {
        return text.replaceAll("labda","lambda");
    }
}
