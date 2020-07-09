package com.springbootbank.bank.common;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Peony
 * @Date: 2020/7/8 20:45
 */
@RestControllerAdvice
public class BankExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest req) {
        e.printStackTrace();
        Result res = new Result("server error",null);
        return new ResponseEntity<Result>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
