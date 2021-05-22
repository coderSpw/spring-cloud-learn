package com.spw.practice.feign;

import com.spw.practice.api.consumer.Consumer;
import com.spw.practice.configuration.FeignConfig;
import com.spw.practice.http.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 服务消费 - 入口
 * @Author spw
 * @Date 2021/5/22
 */
@FeignClient(name = "consumer", configuration = FeignConfig.class, fallback = ConsumerFallback.class)
public interface ConsumerFeign {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/consumer/{id}")
    Result getById(@PathVariable(value = "id") Integer id);

    /**
     * 存储
     * @param consumer
     * @return
     */
    @PostMapping("/consumer/save")
    Result save(@RequestBody Consumer consumer);

    @GetMapping("/consumer/port")
    String port();
}
