package com.yys.spring.license.configs;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OrganizationDiscoveryClient {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    public JSONObject getOrganization(String organizationId){
        //获取组织服务的所有实例的列表
        List<ServiceInstance> instances = discoveryClient.getInstances("organizationservice");
        if(instances.size() == 0){
            return null;
        }
        String serviceUrl = String.format("%s/v1/organizations/%s",instances.get(0).getUri().toString(),organizationId);
        ResponseEntity<JSONObject> restExchange =
                restTemplate.exchange(serviceUrl, HttpMethod.GET,null,JSONObject.class,organizationId);
        return  restExchange.getBody();
    }

    public JSONObject getOrganizationWithRibbon(String organizationId){
        ResponseEntity<JSONObject> restExchange =
                restTemplate.exchange("http://organizationservice/v1/organizations/{organizationId}", HttpMethod.GET,null,JSONObject.class,organizationId);
        return  restExchange.getBody();
    }
}
