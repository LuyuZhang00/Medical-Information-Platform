package com.barry.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-09 22:37
 */
//取消数据源自动配置
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.barry"})
public class ServiceOssApplication {
    public static void main(String[] args) {

        SpringApplication.run(ServiceOssApplication.class, args);
    }
}
