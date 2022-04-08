package com.bberzhou.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @description: 自定义的全局过滤器
 * @author: bberzhou@gmail.com
 * @date: 4/8/2022
 * Create By Intellij IDEA
 */
@Component
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 可以在这里做一些逻辑，例如判断等操作
        log.info("custom global filter");
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null){
            log.info("**************username is not permitted ");
            // 做出一个响应
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        // 继续下一个过滤器
        return chain.filter(exchange);
    }

    /**
     *  优先级，
     *      int HIGHEST_PRECEDENCE = -2147483648;
     *      int LOWEST_PRECEDENCE = 2147483647;
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
