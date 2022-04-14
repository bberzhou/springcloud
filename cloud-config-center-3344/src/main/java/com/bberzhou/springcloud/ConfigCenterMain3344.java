package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description: SpringCloud config 的主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/8/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    /**
     *  测试通过Config微服务是否可以从Github上获取配置内容
     *
     *
     *  SpringCloud Bus 动态刷新全局广播
     *  配置了rabbitmq之后，
     *      ConfigClient 的实例都会监听MQ中的同一个topic（默认是springCloudBus）
     *      当有一个服务刷新数据的时候，他会把这个信息放入到Topic中，这样其他监听同一个topic的服务就能得到通知，然后去更新自身的配置
     *
     *      会刷新当前订阅了所有服务端的client
     *      curl -X POST "http://localhost:3344/actuator/bus-refresh"
     *
     *  那么如何做差异化的定点通知呢？例如只通知client 3355，不通知client3366？
     *
     *  指定具体某一个实例生效而不是全部
     *
     *  公式：http://localhost:配置中心的端口号/actuator/busrefresh/{destination}
     *
     *  此时：
     *      /bus/refresh 请求不再发送到具体的服务实例上，而是发给 config Server 并通过destination参数来指定需要更新配置的服务或者实例
     *      curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"
     *
     *
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
