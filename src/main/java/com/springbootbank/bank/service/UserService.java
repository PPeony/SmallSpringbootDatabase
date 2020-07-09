package com.springbootbank.bank.service;

import com.springbootbank.bank.entity.User;

/**
 * @Author: Peony
 * @Date: 2020/7/8 13:14
 */
public interface UserService {
    User login(String user_phone,String user_password);

    Integer register(User user);


}
