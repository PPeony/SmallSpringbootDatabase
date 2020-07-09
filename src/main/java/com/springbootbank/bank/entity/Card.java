package com.springbootbank.bank.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: Peony
 * @Date: 2020/7/7 16:38
 */
@Data
public class Card implements Serializable {

    private Integer user_id;

    private Integer card_id;

    private String card_number;

    private String card_password;

    private String card_money;

    private Integer is_deleted;
}
