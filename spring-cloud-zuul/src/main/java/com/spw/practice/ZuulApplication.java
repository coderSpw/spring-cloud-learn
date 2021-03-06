package com.spw.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description zuul - 启动类
 * @Author spw
 * @Date 2021/5/22
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
