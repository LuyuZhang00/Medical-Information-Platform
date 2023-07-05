package com.barry.cmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-04 9:38
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.barry")
@EnableDiscoveryClient
public class ServiceCmnApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceCmnApplication.class, args);
    }

}
