package com.laijiantian.zce.user;

import cn.binarywang.tools.generator.*;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.laijiantian.zce.user.entity.SignRecordEntity;
import com.laijiantian.zce.user.entity.UserEntity;
import com.laijiantian.zce.user.service.SignRecordService;
import com.laijiantian.zce.user.service.UserService;
import com.laijiantian.zce.user.service.impl.UserServiceImpl;
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

    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
        for (int i = 0; i < 5; i++) {
            UserEntity userEntity = new UserEntity();
            // 雪花ID
            Snowflake snowflake = IdUtil.getSnowflake(1, 1);
            // 用户英文名
            EnglishNameGenerator nameGenerator = EnglishNameGenerator.getInstance();
            // 中文姓名
            ChineseNameGenerator cng = ChineseNameGenerator.getInstance();
            // UUID
            String uuid = IdUtil.simpleUUID();
            // 密码
            String pwd = DigestUtil.md5Hex(uuid);
            // 手机号
            ChineseMobileNumberGenerator cmng = ChineseMobileNumberGenerator.getInstance();
            //身份证号码
            ChineseIDCardNumberGenerator cidcng = (ChineseIDCardNumberGenerator) ChineseIDCardNumberGenerator.getInstance();
//        System.out.println(cmng.generate());
            // 电子邮箱
            EmailAddressGenerator eag = (EmailAddressGenerator) EmailAddressGenerator.getInstance();

            // set
            userEntity.setUserId(snowflake.nextId());
            userEntity.setUsername(cng.generate()+nameGenerator.generate());
            userEntity.setPassword(pwd);
            userEntity.setMobile(cmng.generate());
            userEntity.setIdNumber(cidcng.generate());
            userEntity.setEmail(eag.generate());
            userEntity.setHeader("www.111.com");
            userEntity.setSign("测试数据-"+1);
            userEntity.setGender(RandomUtil.randomInt(0,1));
            userEntity.setCreateTime(new Date());
//            System.out.println(userEntity);
            System.out.println(userService.save(userEntity));
        }

    }

}
