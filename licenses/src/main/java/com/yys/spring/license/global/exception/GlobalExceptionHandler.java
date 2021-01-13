package com.yys.spring.license.global.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData defaultErrorHander(HttpServletRequest request, Exception e) throws Exception{
        logger.error("",e);
        ResponseData responseData = new ResponseData();
        responseData.setMessage(e.getMessage());
        responseData.setCode(500);
        responseData.setData(null);
        responseData.setStatus(false);
        return responseData;
    }
}
