package com.example.licensingservice2.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class GitConfig {
//
//    @Value("${data.env}")
//    private String env;
//
    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

}
