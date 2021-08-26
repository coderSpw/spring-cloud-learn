package com.spw.cloud.practice.stream.service.impl;

import com.spw.cloud.practice.stream.service.SendMessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author spw
 * @date 2021/8/26
 */
@EnableBinding(Source.class)
public class SendMessageServiceImpl implements SendMessageService {

    @Resource
    private MessageChannel output;


    /**
     * 定时发送 每个5s发送一次
     * @return
     */
    @InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedRate = "5000"))
    public Message<?> delayedMessage() {
        String serial = UUID.randomUUID().toString();
        System.out.println("======> serial:" + serial);
        return MessageBuilder.withPayload(serial).build();
    }

    /**
     * 手动请求发送
     */
    @Override
    public void sendMessage() {
        String serial = UUID.randomUUID().toString();
        System.out.println("======> serial:" + serial);
        output.send(MessageBuilder.withPayload(serial).build());
    }
}
