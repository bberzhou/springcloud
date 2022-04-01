package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.sql.DataSource;

/**
 * @description: 配置eureka服务端主启动类
 * @author: bberzhou@gmail.com
 * @date: 3/31/2022
 * Create By Intellij IDEA
 */
// @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
