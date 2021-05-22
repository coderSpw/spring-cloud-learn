package com.spw.practice.service;

import com.spw.practice.api.producer.Producer;

/**
 * @Description 提供方 - 业务层接口
 * @Author spw
 * @Date 2021/5/22
 */
public interface ProducerService {
    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Producer getById(Integer id);

    /**
     * 保存
     * @param producer
     */
    void save(Producer producer);
}
