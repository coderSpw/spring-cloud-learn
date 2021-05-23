package com.spw.practice.configuration;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @Description 基于redis实现限流过滤器
 * @Author spw
 * @Date 2021/5/23
 */
@Configuration
public class CustomLimiterKeyResolver {

    /**
     * 根据id限流
     * @return
     */
    @Bean
    public KeyResolver hostAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

}
