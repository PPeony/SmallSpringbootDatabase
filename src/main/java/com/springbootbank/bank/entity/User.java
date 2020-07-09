package com.springbootbank.bank.entity;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: Peony
 * @Date: 2020/7/7 16:36
 */
@Data
public class User implements Serializable {

    private Integer user_id;

    private String user_name;

    private String user_password;


    private String user_phone;

    private Integer is_deleted;
}
