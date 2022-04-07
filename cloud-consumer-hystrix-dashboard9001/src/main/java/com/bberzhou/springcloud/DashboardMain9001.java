package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/7/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication

// 开启Hystrix的dashboard
@EnableHystrixDashboard

public class DashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashboardMain9001.class, args);
    }
}
