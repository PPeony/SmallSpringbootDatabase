package com.springbootbank.bank.util;

import com.springbootbank.bank.entity.Transform;

import java.util.Date;

/**
 * @Author: Peony
 * @Date: 2020/7/8 15:50
 */
public class Utils {
    public static boolean nullOrBlank(String s) {
        return (s == null || s.length() < 1) ;
    }
    public static Transform genTrans(Integer card_id,Integer transform_type,
                                     String transform_money) {
        Transform transform = new Transform();
        transform.setCard_id(card_id);
        transform.setTransform_type(transform_type);
        transform.setTransform_money(transform_money);
        transform.setTransform_date(new Date().toString());
        return transform;
    }
}
