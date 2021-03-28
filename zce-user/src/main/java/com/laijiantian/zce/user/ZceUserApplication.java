package com.laijiantian.zce.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@MapperScan("com.laijiantian.zce.user.dao")
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.laijiantian.zce.user.feign")
public class ZceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZceUserApplication.class, args);
    }

}
