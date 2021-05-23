package com.spw.practice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spw.practice.api.consumer.Consumer;
import com.spw.practice.http.Result;
import com.spw.practice.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @Description 服务消费 - 入口
 * @Author spw
 * @Date 2021/5/22
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @Value("${server.port}")
    private Integer port;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable(value = "id") Integer id) {
        Consumer consumer = consumerService.getById(id);
        return Result.sucessResult(consumer);
    }

    /**
     * 存储
     * @param consumer
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Consumer consumer) {
        consumerService.save(consumer);
        return Result.sucessResult();
    }


    @GetMapping("/port")
    @HystrixCommand(fallbackMethod = "fallback"
        , commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2")}
        , threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "1"),
            @HystrixProperty(name = "maxQueueSize", value = "2")}
    )
    public String port() {
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.getMessage();
        }*/
        return "port: " + port;
    }


    private String fallback() {
        return "服务器繁忙，请稍后访问~";
    }

}
