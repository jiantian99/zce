package com.laijiantian.zce.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.laijiantian.zce.user.dao")
public class ZceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZceUserApplication.class, args);
    }

}
