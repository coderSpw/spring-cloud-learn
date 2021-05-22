package com.spw.practice.service;

import com.spw.practice.api.consumer.Consumer;

/**
 * @Description 服务消费 - 业务层接口
 * @Author spw
 * @Date 2021/5/22
 */
public interface ConsumerService {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Consumer getById(Integer id);

    /**
     * 存储
     * @param consumer
     */
    void save(Consumer consumer);
}
