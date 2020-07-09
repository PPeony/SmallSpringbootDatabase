package com.springbootbank.bank.dao;

import com.springbootbank.bank.entity.User;

/**
 * @Author: Peony
 * @Date: 2020/7/7 19:35
 */
public interface UserMapper {
    User selectOne(String user_phone);

    Integer insert(User user);

    Integer update(User user);

    Integer deleteByPrimaryKey(Integer user_id);
}
