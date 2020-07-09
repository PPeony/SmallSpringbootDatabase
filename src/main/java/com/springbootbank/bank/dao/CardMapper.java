package com.springbootbank.bank.dao;

import com.springbootbank.bank.entity.Card;

import java.util.List;

/**
 * @Author: Peony
 * @Date: 2020/7/7 19:40
 */
public interface CardMapper {


    Card selectByPrimaryKey(Integer card_id);

    List<Card> selectByUserId(Integer user_id);

    Integer update(Card card);

    Integer insert(Card card);

    Integer delete(Integer card_id);
}
