package com.spw.practice.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description fegin拦截器 拦截请求参数
 * @Author spw
 * @Date 2021/5/22
 */
@Slf4j
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("feign 拦截请求体数据: {}", requestTemplate.requestBody().asString());
        log.info("feign 拦截请求头数据: {}", requestTemplate.headers());
    }
}
