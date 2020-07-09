package com.springbootbank.bank.service;

import com.springbootbank.bank.entity.Transform;

import java.util.List;

/**
 * @Author: Peony
 * @Date: 2020/7/8 13:18
 */
public interface TransformService {

    List<Transform> getTransformByCardId(Integer card_id);

    Integer saveTransform(Transform transform);

    Integer updateTransform(Transform transform);


}
