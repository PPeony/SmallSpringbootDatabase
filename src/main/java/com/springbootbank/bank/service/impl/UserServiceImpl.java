package com.springbootbank.bank.service.impl;

import com.springbootbank.bank.dao.UserMapper;
import com.springbootbank.bank.entity.User;
import com.springbootbank.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Peony
 * @Date: 2020/7/8 13:39
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User login(String user_phone, String user_password) {
        User user = userMapper.selectOne(user_phone);
        if (user == null) {
            return null;
        }
        if (!user.getUser_password().equals(user_password)) {
            return null;
        }
        return user;
    }

    @Override
    public Integer register(User user) {
        User exist = userMapper.selectOne(user.getUser_phone());
        if (exist != null) {
            //已存在手机号
            return -1;
        }
        return userMapper.insert(user);
    }


}
