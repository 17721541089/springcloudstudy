package com.example.java8.easy.code.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.Map;

import io.swagger.annotations.*;
import io.swagger.models.ExternalDocs;
import io.swagger.models.Model;
import io.swagger.models.properties.Property;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2020-04-21 22:12:50
 */
@Data
@ApiModel("用户表")
public class SysUser {
    private static final long serialVersionUID = 284547139903334604L;
    /**
    * 主键ID
    */    
    @ApiModelProperty("主键ID")
    private Integer userId;
    
        
    @ApiModelProperty("$column.comment")
    private String username;
    
        
    @ApiModelProperty("$column.comment")
    private String password;
    
        
    @ApiModelProperty("$column.comment")
    private String salt;
    
        
    @ApiModelProperty("$column.comment")
    private String phone;
    
        
    @ApiModelProperty("$column.comment")
    private String avatar;
    
    /**
    * 部门ID
    */    
    @ApiModelProperty("部门ID")
    private Integer deptId;
    
    /**
    * 创建时间
    */    
    @ApiModelProperty("创建时间")
    private Date createTime;
    
    /**
    * 修改时间
    */    
    @ApiModelProperty("修改时间")
    private Date updateTime;
    
        
    @ApiModelProperty("$column.comment")
    private String lockFlag;
    
        
    @ApiModelProperty("$column.comment")
    private String delFlag;
    
    /**
    * 微信登录openId
    */    
    @ApiModelProperty("微信登录openId")
    private String wxOpenid;
    
    /**
    * 小程序openId
    */    
    @ApiModelProperty("小程序openId")
    private String miniOpenid;
    
    /**
    * QQ openId
    */    
    @ApiModelProperty("QQ openId")
    private String qqOpenid;
    
    /**
    * 码云 标识
    */    
    @ApiModelProperty("码云 标识")
    private String giteeLogin;
    
    /**
    * 开源中国 标识
    */    
    @ApiModelProperty("开源中国 标识")
    private String oscId;
}