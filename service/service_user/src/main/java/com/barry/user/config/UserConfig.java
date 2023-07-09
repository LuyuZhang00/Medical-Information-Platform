package com.barry.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-09 13:38
 */
@Configuration
@MapperScan("com.barry.user.mapper")
public class UserConfig {

}
