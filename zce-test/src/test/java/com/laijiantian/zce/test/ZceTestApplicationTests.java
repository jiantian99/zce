package com.laijiantian.zce.test;

import com.laijiantian.zce.test.entity.ScorePictureEntity;
import com.laijiantian.zce.test.service.impl.ScorePictureServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ZceTestApplicationTests {

    @Autowired
    ScorePictureServiceImpl service;

    @Test
    void contextLoads() {
//        ScorePictureEntity entity = new ScorePictureEntity();
//        entity.setScoreId(111L);
//        entity.setPicUrl("www.111.com");
//        entity.setPicLocation(0);
//        entity.setCreateTime(new Date());
//        System.out.println(service.save(entity));
        System.out.println(service.list());
    }

}
