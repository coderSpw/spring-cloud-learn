package com.spw.practice.controller;

import com.spw.practice.api.producer.Producer;
import com.spw.practice.http.Result;
import com.spw.practice.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 提供方 - 入口
 * @Author spw
 * @Date 2021/5/22
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable(value = "id") Integer id) {
        Producer producer = producerService.getById(id);
        return Result.sucessResult(producer);
    }


    /**
     * 保存
     * @param producer
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Producer producer) {
        producerService.save(producer);
        return Result.sucessResult();
    }
}
