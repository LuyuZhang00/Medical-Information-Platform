package com.barry.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-10 22:50
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.barry"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.barry"})
public class ServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }
}
