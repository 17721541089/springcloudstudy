package com.example.oauth2;


import com.yys.spring.license.utils.UserContextFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;

@RestController
@EnableResourceServer
//告诉springCloud这是一个OAuth2服务
//@EnableAuthorizationServer
@SpringBootApplication
public class Oauth2Application {

    //添加一个端点/user (映射到/auth/user)
    @RequestMapping(value = "/user",produces = "application/json")
    public Map<String,Object> user(OAuth2Authentication user){
        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("user",user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;

    }

//    @Bean
//    public Filter userContextFilter(){
//        UserContextFilter userContextFilter = new UserContextFilter();
//        return userContextFilter;
//    }
    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }

}
