package com.yys.spring.license.configs;


import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * @loadBalanced注解告诉spring Cloud创建了一个
     * 支持Ribbon的RestTemplate 类
     * 在定义目标服务的URL上有地小小的差异
     * 使用支持Ribbon的RestTempalte类几乎和标准的RestTempalte类一样
     * 我们在调用目标服务的Eureka服务ID来构建目标URL,而不是目标服务
     * 的物理位置
     * @return
     */
    @LoadBalanced
    @Bean
    @ConditionalOnMissingBean({RestOperations.class, RestTemplate.class})
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnMissingBean({ClientHttpRequestFactory.class})
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        //默认的是JDK提供http连接，需要的话可以,通过setRequestFactory方法替换为
        //例如Apache HttpComponents、Netty或//OkHttp等其它HTTP library。
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(15000);//单位为ms
        factory.setConnectTimeout(15000);//单位为ms
        return factory;
    }
}
