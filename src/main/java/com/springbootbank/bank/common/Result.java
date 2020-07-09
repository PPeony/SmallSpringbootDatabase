package com.springbootbank.bank.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Peony
 * @Date: 2020/7/8 14:07
 */
@Data
@AllArgsConstructor
public class Result {
    private String message;
    private Object data;
}
