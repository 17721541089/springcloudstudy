package com.example.java8;

public class mytesy {
    public static void main(String[] args) {
        String code = "100101";
        String provinceCode = code.substring(0,2) + "0000";
        String cityCode = code.substring(0,4) + "00";
        System.out.println(provinceCode+ "-"+cityCode+"-"+code);

    }
}
