package com.bberzhou.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 通用返回对象
 * @author: bberzhou@gmail.com
 * @date: 3/30/2022
 * Create By Intellij IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    /**
     *  请求响应码
     */
    private Integer code;
    /**
     *  请求响应消息
     */
    private String message;
    /**
     * 请求响应数据 ，泛型
     */
    private T data;

    public CommonResult(Integer code ,String message){
        // 调用全参构造器
        this(code,message,null);
    }
}
