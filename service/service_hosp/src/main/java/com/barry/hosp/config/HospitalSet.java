package com.barry.hosp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-03 9:38
 */
@Configuration
@MapperScan("com.barry.hosp.mapper")
public class HospitalSet {
}
