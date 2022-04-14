package com.bberzhou.springcloud.controller;

import com.bberzhou.springcloud.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/14/2022
 * Create By Intellij IDEA
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageService messageService;

    @GetMapping(value = "/senMsg")
    public String sendMsg(){
        return messageService.send();
    }
}
