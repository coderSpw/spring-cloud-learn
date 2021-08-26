package com.spw.cloud.practice.consumer;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author spw
 * @date 2021/8/26
 */
@SpringBootApplication
public class StreamConsumerApplication02 {

    public static void main(String[] args) {
        new SpringApplicationBuilder(StreamConsumerApplication02.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
