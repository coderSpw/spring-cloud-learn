package com.spw.practice.controller;

import com.spw.practice.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author spw
 * @date 2021/12/2
 */
@RefreshScope
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @DubboReference(version = "${dubbo.application.version}", loadbalance = "roundrobin")
    private DemoService demoService;

    @GetMapping("/hello")
    public String sayHello() {
        return demoService.sayHello();
    }

}
