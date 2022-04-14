package com.bberzhou.springcloud.service.impl;

import com.bberzhou.springcloud.service.IMessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @description: 消息接口的实现类
 * @author: bberzhou@gmail.com
 * @date: 4/14/2022
 * Create By Intellij IDEA
 */
// 这个注解，定义消息生产者的推送管道，
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageService {

    /**
     * 消息发送管道，而且必须指定为output
     */

    @Resource

    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();

        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*********serial"+serial);
        return null;
    }
}
