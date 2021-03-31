package com.laijiantian.zce.test;

import cn.binarywang.tools.generator.ChineseNameGenerator;
import cn.binarywang.tools.generator.EnglishNameGenerator;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.laijiantian.zce.test.entity.ProductEntity;
import com.laijiantian.zce.test.entity.ScorePictureEntity;
import com.laijiantian.zce.test.service.impl.ProductServiceImpl;
import com.laijiantian.zce.test.service.impl.ScorePictureServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
class ZceTestApplicationTests {

    @Autowired
    ScorePictureServiceImpl service;

    @Autowired
    ProductServiceImpl productService;

    @Test
    void contextLoads() {
        for (int i = 0; i < 5; i++) {
            Snowflake snowflake = IdUtil.getSnowflake(3, 1);
            EnglishNameGenerator nameGenerator = EnglishNameGenerator.getInstance();
            //中文姓名
            ChineseNameGenerator cng = ChineseNameGenerator.getInstance();
            long id = snowflake.nextId();
            ProductEntity productEntity = new ProductEntity();
            productEntity.setProductId(id);
            productEntity.setProductName(nameGenerator.generate());
            productEntity.setProductPicture("www.1.com");
            productEntity.setRemarks(cng.generate());
            productEntity.setCreateTime(new Date());
            System.out.println(productService.save(productEntity));
        }
//        System.out.println(nameGenerator.generate());

//        System.out.println(id);
    }

}
