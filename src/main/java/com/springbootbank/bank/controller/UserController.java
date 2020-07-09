package com.springbootbank.bank.controller;

import com.springbootbank.bank.common.Result;
import com.springbootbank.bank.entity.User;
import com.springbootbank.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

/**
 * @Author: Peony
 * @Date: 2020/7/8 14:03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/login")
    public HttpEntity login(@RequestBody User user0, HttpSession session) {

        String user_phone = user0.getUser_phone(),user_password = user0.getUser_password();
        if (user_phone == null || user_password == null
        || user_phone.length() <1 || user_password.length() < 1) {
            Result res = new Result("please input your message",null);
            return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
        }
        if (!Pattern.matches("^[1][3,4,5,7,8][0-9]{9}$",user_phone)) {
            Result res = new Result("please input your phone number correctly",null);
            return new ResponseEntity(res,HttpStatus.BAD_REQUEST);
        }

        User user = userService.login(user_phone,user_password);
        if (user != null) {
            session.setAttribute("user_id",user.getUser_id());
            Result res = new Result("accept",null);
            return new ResponseEntity(res,HttpStatus.OK);
        } else{
            Result res = new Result("wrong password or phone number",null);
            return new ResponseEntity(res,HttpStatus.UNAUTHORIZED);
        }

    }
    @PostMapping("/register")
    public HttpEntity register(@RequestBody User user) {
        Result res;
        if (user.getUser_phone() == null || user.getUser_phone().length() < 1 ||
        user.getUser_name() == null || user.getUser_name().length() < 1 ||
        user.getUser_password() == null || user.getUser_password().length() < 1) {
            res = new Result("please input your message",null);
            return new ResponseEntity(res,HttpStatus.BAD_REQUEST);
        }

        int r = userService.register(user);
        if (r > 0) {
            //after register, the view will be redirected to login
            //so session operation is not necessary
            res = new Result("success",null);
            return new ResponseEntity(res,HttpStatus.CREATED);
        }
        System.out.println("error");
        res = new Result("please change another phone number",null);
        return new ResponseEntity(res,HttpStatus.UNAUTHORIZED);
    }


}
