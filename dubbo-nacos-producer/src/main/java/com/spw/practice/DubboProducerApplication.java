package com.spw.practice;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author spw
 * @date 2021/12/2
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DubboProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProducerApplication.class, args);
    }
}
