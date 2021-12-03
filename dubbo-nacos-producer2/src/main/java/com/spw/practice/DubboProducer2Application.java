package com.spw.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author spw
 * @date 2021/12/3
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DubboProducer2Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboProducer2Application.class, args);
    }
}
