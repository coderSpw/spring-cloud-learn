package com.spw.practice.repository;

import com.spw.practice.api.producer.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 提供方 - 持久层接口
 * @Author spw
 * @Date 2021/5/22
 */
@Repository
public interface ProducerRepository extends CrudRepository<Producer, Integer> {
}
