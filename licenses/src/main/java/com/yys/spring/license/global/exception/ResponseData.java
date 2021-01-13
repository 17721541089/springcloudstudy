package com.yys.spring.license.global.exception;

import lombok.Data;

@Data
public class ResponseData<T> {
    private Boolean status = true;
    private int code = 200;
    private String message;
    private T data;
}
