package com.springbootbank.bank.controller;

import com.springbootbank.bank.common.Result;
import com.springbootbank.bank.dao.CardMapper;
import com.springbootbank.bank.entity.Card;
import com.springbootbank.bank.entity.Transform;
import com.springbootbank.bank.service.CardService;
import com.springbootbank.bank.service.TransformService;
import com.springbootbank.bank.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: Peony
 * @Date: 2020/7/8 15:33
 */
@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @Autowired
    TransformService transformService;


    @PostMapping("/addCard")
    public HttpEntity addCard(@RequestBody Card card,HttpSession session) {
        String card_number = card.getCard_number(),card_password = card.getCard_password();
        Result res ;
        if (Utils.nullOrBlank(card_number) || Utils.nullOrBlank(card_password)) {
            res = new Result("please input message",null);
            return new ResponseEntity(res,HttpStatus.BAD_REQUEST);
        }
        if (card.getUser_id() != null && card.getUser_id().equals(session.getAttribute("user_id"))) {
            res = new Result("message wrong",null);
            return new ResponseEntity(res,HttpStatus.BAD_REQUEST);
        }
        card.setUser_id((Integer)session.getAttribute("user_id"));
        int r = cardService.addCard(card);
        if (r > 0) {
            res = new Result("success",null);
            return new ResponseEntity(res,HttpStatus.OK);
        } else {
            res = new Result("unknown errors",null);
            return new ResponseEntity(res,HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/saveMoney")
    public HttpEntity saveMoney(@RequestBody Card card) {
        String card_money = card.getCard_money();
        Integer card_id = card.getCard_id();
        String card_password = card.getCard_password();
        Result res ;
        if (card_id == null || Utils.nullOrBlank(card_money) ||
                Utils.nullOrBlank(card_password)) {
            res = new Result("please input correct message",null);
            return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
        }
        int r = cardService.saveMoney(card_money,card_id,card_password);
        if (r > 0) {
            Transform transform = Utils.genTrans(card_id,1,card_money);
            transformService.saveTransform(transform);
            res = new Result("success",null);
            return new ResponseEntity(res,HttpStatus.CREATED);
        } else {
            res = new Result("failure",null);
            return new ResponseEntity(res,HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/depositMoney")
    public HttpEntity depositMoney(@RequestBody Card card) {
        String card_money = card.getCard_money();
        Integer card_id = card.getCard_id();
        String card_password = card.getCard_password();
        Result res ;
        if (card_id == null || Utils.nullOrBlank(card_money) ||
                Utils.nullOrBlank(card_password)) {
            res = new Result("please input correct message",null);
            return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
        }
        int r = cardService.depositMoney(card_money,card_id,card_password);
        if (r > 0) {
            Transform transform = Utils.genTrans(card_id,2,card_money);
            transformService.saveTransform(transform);
            res = new Result("success",null);
            return new ResponseEntity(res,HttpStatus.CREATED);
        } else {
            res = new Result("you dont have enough money",null);
            return new ResponseEntity(res,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allCards")
    public HttpEntity getAllCards(HttpSession session) {
        Result res;
        Integer user_id = (Integer) session.getAttribute("user_id");
        List<Card> list = cardService.getCard(user_id);
        res = new Result("success",list);
        return new ResponseEntity(res,HttpStatus.OK);
    }
    @GetMapping("/{card_id}")
    public HttpEntity getCard(@PathVariable Integer card_id,HttpSession session) {
        Card card = cardService.getConcreteCard(card_id);
        Result res;
        if (card == null) {
            res = new Result("no this card",null);
            return new ResponseEntity(res,HttpStatus.BAD_REQUEST);
        }
        if (card.getUser_id() != session.getAttribute("user_id")) {
            res = new Result("you dont have this card",null);
            return new ResponseEntity(res,HttpStatus.NOT_FOUND);
        }
        res = new Result("success",card);
        return new ResponseEntity(res,HttpStatus.OK);
    }
}
