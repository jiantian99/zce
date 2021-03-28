package com.laijiantian.zce.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@MapperScan("com.laijiantian.zce.test.dao")
@EnableDiscoveryClient
public class ZceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZceTestApplication.class, args);
    }

}
