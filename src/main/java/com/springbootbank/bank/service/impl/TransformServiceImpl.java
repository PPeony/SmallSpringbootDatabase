package com.springbootbank.bank.service.impl;

import com.springbootbank.bank.dao.TransformMapper;
import com.springbootbank.bank.entity.Transform;
import com.springbootbank.bank.service.TransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Peony
 * @Date: 2020/7/8 14:01
 */
@Service
public class TransformServiceImpl implements TransformService {

    @Autowired
    TransformMapper transformMapper;

    @Override
    public List<Transform> getTransformByCardId(Integer card_id) {
        return transformMapper.selectAll(card_id);
    }

    @Override
    public Integer saveTransform(Transform transform) {
        return transformMapper.insert(transform);
    }

    @Override
    public Integer updateTransform(Transform transform) {
        return transformMapper.update(transform);
    }
}
