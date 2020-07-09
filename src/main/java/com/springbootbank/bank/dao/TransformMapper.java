package com.springbootbank.bank.dao;

import com.springbootbank.bank.entity.Transform;

import java.util.List;

/**
 * @Author: Peony
 * @Date: 2020/7/7 19:54
 */
public interface TransformMapper {


    List<Transform> selectAll(Integer card_id);

    Integer insert(Transform transform);

    Integer update(Transform transform);

    Integer delete(Integer transform_id);
}
