package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/7/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
    /**
     *  Route（路由），路由是构建网关的基本模块，它由ID，目标URI，一系列的断言和过滤器组成，如果断言为true则匹配该路由
     *
     *  Predicate（断言），参考的是Java8的java.util.function.Predicate
     *                  开发人员可以匹配HTTP请求中的所有内容（例如请求头或者请求参数），如果请求与断言相匹配则进行路由
     *
     *
     *  Filter（过滤）指的是Spring框架中GatewayFilter的实例，使用过滤器，可以在请求被路由前或者之后对请求进行修改
     *
     *
     *  SpringCloud Config 为微服务架构中的微服务提供集中化的外部配置支持，
     *  配置服务器为各个把不同微服务应用的所有环境提供了一个中心化的外部配置
     *
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class,args);
    }
}
