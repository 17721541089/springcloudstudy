package com.example.licensingservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class Licensingservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Licensingservice2Application.class, args);
    }

}
