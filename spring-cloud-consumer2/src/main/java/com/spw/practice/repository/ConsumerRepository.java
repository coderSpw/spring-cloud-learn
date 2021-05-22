package com.spw.practice.repository;

import com.spw.practice.api.consumer.Consumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 服务消费 - 持久层接口
 * @Author spw
 * @Date 2021/5/22
 */
@Repository
public interface ConsumerRepository extends CrudRepository<Consumer, Integer> {
}
