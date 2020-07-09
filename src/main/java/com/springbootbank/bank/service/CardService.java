package com.springbootbank.bank.service;

import com.springbootbank.bank.entity.Card;

import java.util.List;

/**
 * @Author: Peony
 * @Date: 2020/7/8 13:16
 */
public interface CardService {

    Integer saveMoney(String money,Integer card_id,String card_password);

    Integer depositMoney(String money,Integer card_id,String card_password);

    List<Card> getCard(Integer user_id);

    Card getConcreteCard(Integer card_id);

    Integer addCard(Card card);
}
