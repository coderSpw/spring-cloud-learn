package com.spw.cloud.practice.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author spw
 * @date 2021/8/26
 */
@EnableBinding(Sink.class)
public class ReceiveMessage {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(@Payload String in) {
        System.out.println("consumer02 ----> port:" + port + " message: " + in);
    }
}
