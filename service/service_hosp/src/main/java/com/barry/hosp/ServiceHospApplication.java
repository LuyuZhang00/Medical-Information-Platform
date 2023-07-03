package com.barry.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-03 8:40
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.barry")
public class ServiceHospApplication {
    public static void main(String[] args) {

        SpringApplication.run(ServiceHospApplication.class, args);
    }
}
