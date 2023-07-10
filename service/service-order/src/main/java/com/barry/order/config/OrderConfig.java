package com.barry.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-10 23:00
 */
@Configuration
@MapperScan("com.barry.order.mapper")
public class OrderConfig {
}
