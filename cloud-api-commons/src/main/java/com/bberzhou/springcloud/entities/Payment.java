package com.bberzhou.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 支付实体类
 * @author: bberzhou@gmail.com
 * @date: 3/30/2022
 * Create By Intellij IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
