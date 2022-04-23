package com.bberzhou.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description: 测试Sentinel的流量监控和熔断等
 * @author: bberzhou@gmail.com
 * @date: 4/16/2022
 * Create By Intellij IDEA
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() {
        // 这里演示sentinel的流量控制的线程数，当一个线程进来在1秒时间内，还有其他线程进来就会报错
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }


        return "....................testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "........testB");
        return "===============testB";
    }

    /**
     * 测试sentinel 的服务降级
     *
     * @return
     */
    @GetMapping("/testD")
    public String testD() {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return ".......................testD";
    }

    /**
     * 测试异常数限流
     *
     * @return
     */
    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10 / 0;
        return "testE................测试异常数";
    }

    /**
     * 配置sentinel的 兜底方法
     * value就是需要兜底的请求，
     * blockHandler 就是指定兜底的方法名
     *
     * 这里要注意：
     *  @SentinelResource 注解处理得是Sentienl控制台配置得违规情况，有blockHandler方法配置的兜底处理
     *
     *  而如果是程序逻辑出现异常，比如 int 10/0，这个是Java运行时异常RunTimeException，@SentinelResource 就管不到
     *  因此：@SentinelResource 主要是管配置出错，而运行出错则是该走异常就走异常
     *
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotkey")
    public String testHotkey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        // int a = 10/0;
        return "....................test hotkey";
    }

    public String dealTestHotkey(String p1, String p2, BlockException blockException){
        // sentinel的系统默认的提示：Blocked by sentinel(flow limiting)
        return "dealTestHotkey=============exception";
    }

}
