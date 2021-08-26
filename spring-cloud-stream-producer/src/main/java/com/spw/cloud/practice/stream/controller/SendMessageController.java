package com.spw.cloud.practice.stream.controller;

import com.spw.cloud.practice.stream.service.SendMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author spw
 * @date 2021/8/26
 */
@RestController
public class SendMessageController {

    @Resource
    private SendMessageService sendMessageService;

    @GetMapping("/sendMessage")
    public void sendMessage() {
        sendMessageService.sendMessage();
    }
}
