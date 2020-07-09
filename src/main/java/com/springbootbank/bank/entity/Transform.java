package com.springbootbank.bank.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Peony
 * @Date: 2020/7/7 19:31
 */
@Data
public class Transform implements Serializable {
    private Integer card_id;

    private Integer transform_id;

    private Integer transform_type;

    private String transform_money;

    private String transform_date;

    private Integer is_deleted;
}
