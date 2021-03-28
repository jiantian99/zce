package com.laijiantian.zce.user;

import com.laijiantian.zce.user.entity.SignRecordEntity;
import com.laijiantian.zce.user.entity.UserEntity;
import com.laijiantian.zce.user.service.SignRecordService;
import com.laijiantian.zce.user.service.UserService;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
class ZceUserApplicationTests {


    @Autowired
    SignRecordService signRecordService;

    @Test
    void contextLoads() {
        SignRecordEntity signRecordEntity = new SignRecordEntity();
        signRecordEntity.setUserId(111L);
        signRecordEntity.setSignDate(new Date());
        signRecordEntity.setLastSign(new Date());
        System.out.println(signRecordService.save(signRecordEntity));
    }

}
