package com.bberzhou.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 自定义负载均衡的规则
 * @author: bberzhou@gmail.com
 * @date: 4/2/2022
 * Create By Intellij IDEA
 */

@Configuration
public class MySelfRule {
    /**
     *  注意，自定义规则的时候，不能放在@ComponentScan 注解扫描包下面，因此需要新建一个平级的新包
     *
     */
    @Bean
    public IRule myRule(){
        /**
         *  默认是采用的轮询机制，现在自定义为使用随机Rule ，还需要在主启动类上添加注解
         */
        return new RandomRule();
    }
}
