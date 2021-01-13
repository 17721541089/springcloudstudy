package com.yys.spring.springgateway;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringgatewayApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // basic proxy
                .route(r -> r.path("/baidu")
                        .uri("http://baidu.com:80/"))
                .build();
    }

    private final Executor executor = Executors.newFixedThreadPool(5, new
            ThreadFactory() {
                private  int i = 0;
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r,"name"+i++);
                    //设置为守护线程--这种方式不会阻止程序关闭
                    t.setDaemon(true);
                    return t;
                }
            });

    public  void main(String[] args) {
        CompletableFuture.supplyAsync(()->test(),executor);
    }

    public static String test(){
        return "";
    }


}
