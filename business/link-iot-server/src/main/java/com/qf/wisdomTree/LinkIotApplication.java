package com.qf.wisdomTree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.qf.**.openFeign")
public class LinkIotApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkIotApplication.class,args);
    }
}
