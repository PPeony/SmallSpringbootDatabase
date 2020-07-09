package com.springbootbank.bank.service.impl;

import com.springbootbank.bank.dao.CardMapper;
import com.springbootbank.bank.entity.Card;
import com.springbootbank.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Peony
 * @Date: 2020/7/8 13:18
 */
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardMapper cardMapper;

    @Override
    public Integer saveMoney(String money, Integer card_id,String card_password) {
        Card card = cardMapper.selectByPrimaryKey(card_id);
        if (card == null || !card.getCard_password().equals(card_password)) {
            return -1;
        }
        Double dm = Double.valueOf(money);
        card.setCard_money(String.valueOf(Double.valueOf(card.getCard_money())+dm));
        return cardMapper.update(card);
    }

    @Override
    public Integer depositMoney(String money, Integer card_id,String card_password) {
        Card card = cardMapper.selectByPrimaryKey(card_id);
        if (card == null || !card.getCard_password().equals(card_password)) {
            return -1;
        }
        Double dm = Double.valueOf(money);
        Double om = Double.valueOf(card.getCard_money());
        if (om < dm) {
            return -1;
        }
        card.setCard_money(String.valueOf(om-dm));
        return cardMapper.update(card);
    }

    @Override
    public List<Card> getCard(Integer user_id) {
        return cardMapper.selectByUserId(user_id);
    }

    @Override
    public Card getConcreteCard(Integer card_id) {
        return cardMapper.selectByPrimaryKey(card_id);
    }


    @Override
    public Integer addCard(Card card) {
        return cardMapper.insert(card);
    }
}
