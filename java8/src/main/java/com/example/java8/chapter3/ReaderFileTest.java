//package com.example.java8.chapter3;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class ReaderFileTest {
//    public static void main(String[] args) throws IOException{
//
//
//
//
//
//
//
//        String oneLine = processFile((BufferedReader br) -> br.readLine());
//        System.out.println(oneLine);
//        System.out.println("****************************");
//        String twoLine = processFile((BufferedReader br) -> br.readLine()+"\n" +br.readLine());
//        System.out.println(twoLine);
//    }
//
//    public static String processFile(BufferedReaderProcessor p) throws IOException{
//        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/DELL/Desktop/new 2.txt"))) {
//            return  p.process(br);
//        }
//    }
//
//    public static String processFile(String fileName) throws IOException{
//        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//            return  br.readLine();
//        }
//    }
//}
