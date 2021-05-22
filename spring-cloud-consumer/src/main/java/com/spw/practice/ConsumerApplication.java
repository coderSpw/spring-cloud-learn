package com.spw.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description 服务消费方 - 启动类
 * @Author spw
 * @Date 2021/5/22
 */

@EnableEurekaClient
@SpringBootApplication
@EntityScan(basePackages = "com.spw.practice.api.consumer")
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
