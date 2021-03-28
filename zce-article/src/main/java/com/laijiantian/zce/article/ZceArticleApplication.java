package com.laijiantian.zce.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.laijiantian.zce.article.dao")
public class ZceArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZceArticleApplication.class, args);
    }

}
