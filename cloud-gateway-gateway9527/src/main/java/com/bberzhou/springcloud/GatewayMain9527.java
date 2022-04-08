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
     *  SpringCloud Config 为微服务架构中的微服务提供集中化的外部配置支持，配置服务器为各个把不同微服务应用的所有环境提供了一个中心化的外部配置
     *  SpringCloud config也分为服务端和客户端两个部分，
     *      服务端也称为分布式配置中心，它是一个独立得微服务应用，用来连接配置服务器并为客户端提供获取配置信息，加密/解密信息等访问接口
     *
     *      客户端则是通过指定的配置中心来管理应用资源，以及与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息
     *      配置服务器默认采用git来存储配置信息，这样就有助于对环境配置进行版本管理，并且可以通过git客户端工具来方便的管理和访问配置内容
     *
     *
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class,args);
    }
}
