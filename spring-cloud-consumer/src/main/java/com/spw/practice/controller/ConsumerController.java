package com.spw.practice.controller;

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
    private String port;

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
    public String port() {
        /*try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.getMessage();
        }*/
        return "port: " + port;
    }
}
