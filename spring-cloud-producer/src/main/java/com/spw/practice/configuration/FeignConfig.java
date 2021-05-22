package com.spw.practice.configuration;

import feign.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.TimeUnit;

/**
 * @Description fegin 配置类
 * @Author spw
 * @Date 2021/5/22
 */
@Configuration
public class FeignConfig {

    /**
     * 重试  没100ms重试一次  最多重试3次
     * @return
     */
    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 3);
    }

    /**
     * 请求与响应日志记录
     * none  不记录日志
     * basic 只记录方法和url以及响应状态码 执行时间
     * headers 记录请求和应答的头信息
     * full 记录请求和响应的头信息 正文  元数据
     */
    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }

    /**
     * 添加请求拦截器
     * @return
     */
    @Bean
    public RequestInterceptor requestTemplate() {
        return new FeignInterceptor();
    }
}
