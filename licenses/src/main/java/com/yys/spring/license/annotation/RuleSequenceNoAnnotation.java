package com.yys.spring.license.annotation;

import java.lang.annotation.*;

/**
 * 风控规则注解
 * 希望通过注解对应的值找到对应的规则对应的方法
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RuleSequenceNoAnnotation {
    String value();
    String msg();
}
