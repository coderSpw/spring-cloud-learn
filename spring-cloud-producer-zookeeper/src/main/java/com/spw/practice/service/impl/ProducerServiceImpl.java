package com.spw.practice.service.impl;

import com.spw.practice.api.producer.Producer;
import com.spw.practice.repository.ProducerRepository;
import com.spw.practice.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @Description 提供方 - 业务层实现类
 * @Author spw
 * @Date 2021/5/22
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public Producer getById(Integer id) {
        return producerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Producer producer) {
        producer.setPayTime(new Date());
        producerRepository.save(producer);
    }
}
