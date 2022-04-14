package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: Stream send 主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/14/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
public class StreamMQMain8801 {

    /**
     *  注意 stream里面的几个注解：
     *      1、Middleware，中间件，目前只支持RabbitMQ和Kafka
     *      2、Binder，Binder是应用与消息中间件之间的封装，目前实现了RabbitMQ和Kafka的binder，
     *          通过Binder可以很方便的连接中间件，可以动态的改变消息类型（对应于Kafka的topic，RabbitMQ的exchange）
     *          这些都可以通过配置文件来实现
     *
     *      3、@Input； 注解，标识输入通道，通过该输入通道接收到消息进入应用程序（消费者）
     *      4、@Output：注解标识输出通道，发布的消息将通过该通道离开应用程序（生产者）
     *      5、@StreamListener,监听队列，用于消费者的队列的消息接收
     *      6、@EnableBinding，指信道channel 和exchange 绑定在一起
     *
     *
     *
     *      7001 做服务注册
     *      8801 消息生产
     *      8802 消息消费
     *      8803 消息消费
     *
     *      rabbitmq默认是topic 订阅模式
     *      重复消费问题：
     *
     *      如果一个消息同时被两个服务获取到，就可能出现消息重复消费的情况，（例如一个订单同时被两个服务获取到），造成数据错误
     *
     *      就可以使用Stream中的消息分组来解决这个问题：
     *
     *      就是在Stream中处于同一个group中的多个消费者是竞争关系，就能够保证消息只会被其中一个应用消费一次
     *      不同的组是可以全面消费的（重复消费）
     *      在同一个组内的就是属于竞争关系，只能被消费一次，默认也是采用的轮询机制
     *      ============================================
     *
     *      持久化的问题：
     *         当某些消费微服务宕机时，生产者继续生产的消息会被保留在之前的分组中，当原来分组中的消费者重启之后就会消费掉那些消息
     *         而新分组里面的消费者启动时不会把这些未被消费的信息消费掉
     *         所以如果不加group的话，可能就会出现消息的丢失，因为随机分组的话，第二次启动就改变了，就收不到宕机时间段生产者生产的消息
     *
     * @param args
     */



    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8801.class,args);
    }
}
