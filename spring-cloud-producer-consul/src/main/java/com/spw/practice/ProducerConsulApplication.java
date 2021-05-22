package com.spw.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description 提供方服务启动类
 * @Author spw
 * @Date 2021/5/22
 */
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = "com.spw.practice.api.producer")
public class ProducerConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerConsulApplication.class, args);
    }
}
