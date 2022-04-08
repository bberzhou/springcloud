package com.bberzhou.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 在服务端3344中的配置文件会以REST接口的形式暴露出来
 * @author: bberzhou@gmail.com
 * @date: 4/8/2022
 * Create By Intellij IDEA
 */
@RestController
// 这个注解就是为了动态刷新
// 需要热加载的bean需要加上 @RefreshScope注解，当配置发生变更的时候，可以在不重启应用的前提下完成bean中相关属性的刷新

// 使用此注解之后，还需要手动进行刷新一下： 发一个POST请求，可以不用重启服务，就能够进行刷新
// curl -X POST "http://localhost:3355/actuator/refresh"
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    /**
     * 从服务端获取相关的配置文件, 通过访问服务中心的3344来获取对应的配置文件
     *
     *
     *  存在的问题，当修改了GitHub上面的配置文件内容，3344，重新请求时，可以发现ConfigServer配置中心可以立刻响应
     *          刷新3355，发现ConfigClient客户端没有任何的响应
     *     3355 没有变化除非自己重启或者重新加载
     *
     *     问题：其他需要依赖配置中心的组件，怎么做到动态刷新呢？
     *
     *     解决方法：
     *      1、手动解决：在对应的Controller上面添加上 @RefreshScope 注解，然后手动刷新一下 curl -X POST "http://localhost:3355/actuator/refresh"
     *      2、如何做到广播通知，大范围的自动刷新，做到差异化的管理，该更新的才更新
     *
     * @return
     */
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
