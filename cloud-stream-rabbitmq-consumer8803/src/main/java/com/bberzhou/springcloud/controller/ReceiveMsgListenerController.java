package com.bberzhou.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 8803消费者的controller
 * @author: bberzhou@gmail.com
 * @date: 4/14/2022
 * Create By Intellij IDEA
 */
@RestController
// 这个注解，相当于是开启消费者的推送管道
@EnableBinding(Sink.class)
public class ReceiveMsgListenerController {

    @Value("${server.port}")
    private String serverPort;

    // @StreamListener(Sink.INPUT)
    // public void input(@Payloads String in, @Header(AmqpHeaders.CONSUMER_QUEUE) String queue){
    //     System.out.println("consumer No.1，-----------》：接收到消息:"+ in+"\t"+"receivede "+queue.toString()+"\t"+"serverPort:"+serverPort);
    // }
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("consumer No.8803，-----------》：接收到消息:"+message.getPayload()+"\t"+"serverPort:"+serverPort);
    }
}
