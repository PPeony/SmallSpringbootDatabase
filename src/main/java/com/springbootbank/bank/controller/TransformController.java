package com.springbootbank.bank.controller;

import com.springbootbank.bank.common.Result;
import com.springbootbank.bank.entity.Transform;
import com.springbootbank.bank.service.TransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Peony
 * @Date: 2020/7/8 16:28
 */
@RestController
@RequestMapping("/transform")
public class TransformController {
    @Autowired
    TransformService transformService;

    @GetMapping("/{card_id}")
    public HttpEntity getAllTransform(@PathVariable Integer card_id) {
        List<Transform> transformList = transformService.getTransformByCardId(card_id);
        Result res = new Result("success",transformList);
        return new ResponseEntity(res, HttpStatus.OK);
    }
}
