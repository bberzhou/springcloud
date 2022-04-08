package com.bberzhou.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: Gateway 的配置类
 * @author: bberzhou@gmail.com
 * @date: 4/7/2022
 * Create By Intellij IDEA
 */
@Configuration
public class GateConfig {

    /**
     *
     * Gateway网关路由的两种配置方式：
     *
     *  1、通过配置类的方式，如下面所示。
     *  2、通过配置文件的方式，在application.xml中
     *
     *
     *  配置了一个id为path_payment_route的路由规则
     *  当访问地址http://localhost:9527/guonei时就会自动转发到地址  http://news.baidu.com/guonei
     *
     *
     *
     *  默认情况下Gateway会根据注册中心注册的服务列表，
     *  以注册中心上微服务名为路径创建动态路由进行转发，从而实现动态路由的功能
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_payment_route",
                        r -> r.path("/guonei")
                                .uri("http://news.baidu.com/guonei")).build();
    }

    @Bean
    public RouteLocator routes2(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_payment_route2",
                        r -> r.path("/guoji")
                                .uri("http://news.baidu.com/guoji")).build();

    }
}
