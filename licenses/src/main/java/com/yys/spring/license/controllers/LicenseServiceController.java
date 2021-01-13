//package com.yys.spring.license.controllers;
//
//import com.alibaba.fastjson.JSONObject;
//import com.yys.spring.license.configs.GitConfig;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@Api(tags = {"证书"})
//@RestController
//@RequestMapping("/v1/organizations/{organizationId}/license")
//public class LicenseServiceController {
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Autowired
//    GitConfig gitConfig;
//
//    @ApiOperation(value = "获取证书")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "header", name = "token", value = "身份认证Token"),
//            @ApiImplicitParam(paramType = "header", name = "credential", value = "验签Token", required = true),
//            @ApiImplicitParam(paramType = "path", name = "organizationId",value = "组织ID"),
//            @ApiImplicitParam(paramType = "path",name = "licenseId",value = "证书ID")
//    })
//    @RequestMapping(value = "/{licenseId}",method = RequestMethod.GET)
//    public JSONObject getLicense(@PathVariable("organizationId") String organizationId,
//            @PathVariable("licenseId") String licenseId){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("organizationId",organizationId);
//        jsonObject.put("licenseId",licenseId);
//        ResponseEntity<?> restExchage =  restTemplate.exchange("HttpUrl", HttpMethod.GET,null,String.class,"","");
//        restExchage.getBody();
//        return jsonObject;
//    }
//
//    @ApiOperation(value = "测试从配置中心获取数据")
//    @RequestMapping(value = "/test",method = RequestMethod.GET)
//    public JSONObject getGitConfig(){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("gitConfig",gitConfig);
//        return jsonObject;
//    }
//
//}
