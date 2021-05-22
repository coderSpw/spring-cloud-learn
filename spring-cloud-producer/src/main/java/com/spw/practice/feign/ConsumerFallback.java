package com.spw.practice.feign;

import com.spw.practice.api.consumer.Consumer;
import com.spw.practice.http.Result;
import org.springframework.stereotype.Component;

/**
 * @Description  服务消费  - 兜底
 * @Author spw
 * @Date 2021/5/22
 */
@Component
public class ConsumerFallback implements ConsumerFeign {
    @Override
    public Result getById(Integer id) {
        return this.consumerFullback();
    }

    @Override
    public Result save(Consumer consumer) {
        return this.consumerFullback();
    }

    @Override
    public String port() {
        return "服务正在重启中~~~~~~~";
    }

    private Result consumerFullback() {
        return Result.failResult("服务正在重启中~~~~~~~");
    }
}
