package com.bberzhou.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试自动刷新配置文件
 * @author: bberzhou@gmail.com
 * @date: 4/13/2022
 * Create By Intellij IDEA
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort;

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
     *
     *      上述这种方法比较笨重，需要每一个都手动操作，因此可以使用消息总线 bus 来进行广播操作
     *
     *      利用消息总线，一般有两种方法：
     *      1）利用消息总线触发一个客户端（例如这里触发3355或者3366）的/bus/refresh，来刷新所有客户端的配置，然后客户端再进行传递，以此传递刷新所有客户端的配置
     *      2）利用消息总线来触发一个服务端（例如这里3344）ConfigServer的 /bus/refresh的端点，（较常用一点）
     *
     *
     *
     * @return
     */
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "serverPort:"+serverPort+"\t"+"config："+configInfo;
    }
}
