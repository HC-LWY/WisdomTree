package com.qf.wisdomTree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GreenhouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreenhouseApplication.class,args);
    }
}
