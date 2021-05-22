package com.spw.practice.service.impl;

import com.spw.practice.api.consumer.Consumer;
import com.spw.practice.api.producer.Producer;
import com.spw.practice.feign.ConsumerFeign;
import com.spw.practice.repository.ProducerRepository;
import com.spw.practice.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * @Description 提供方 - 业务层实现类
 * @Author spw
 * @Date 2021/5/22
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private ConsumerFeign consumerFeign;

    @Override
    public Producer getById(Integer id) {
        return producerRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Producer producer) {
        //存支付表
        producer.setPayTime(new Date());
        producerRepository.save(producer);
        //存订单表
        Consumer consumer = Consumer.builder().payId(producer.getId())
                .createTime(new Date())
                .ordNo(UUID.randomUUID().toString().replaceAll("-", ""))
                .build();
        consumerFeign.save(consumer);
    }
}
