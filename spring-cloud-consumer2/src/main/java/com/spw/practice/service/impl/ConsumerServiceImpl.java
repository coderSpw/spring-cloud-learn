package com.spw.practice.service.impl;

import com.spw.practice.api.consumer.Consumer;
import com.spw.practice.repository.ConsumerRepository;
import com.spw.practice.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @Description 服务消费 - 业务层实体类
 * @Author spw
 * @Date 2021/5/22
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerRepository consumerRepository;

    @Override
    public Consumer getById(Integer id) {
        return consumerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Consumer consumer) {
        consumerRepository.save(consumer);
    }
}
