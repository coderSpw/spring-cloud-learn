package com.spw.practice.service.impl;

import com.spw.practice.service.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author spw
 * @date 2021/12/3
 */
@RefreshScope
@DubboService(version = "${dubbo.application.version}")
public class DemoServiceImpl implements DemoService {

    @Value("${server.port}")
    private Integer port;
    @Value("${profile.name}")
    private String name;

    @Override
    public String sayHello() {
        return "hello :" + name + "-" + port;
    }
}
