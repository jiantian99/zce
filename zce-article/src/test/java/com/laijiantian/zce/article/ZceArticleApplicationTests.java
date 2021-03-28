package com.laijiantian.zce.article;

import com.laijiantian.zce.article.entity.RecordEntity;
import com.laijiantian.zce.article.service.RecordService;
import com.laijiantian.zce.article.service.impl.RecordServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ZceArticleApplicationTests {

    @Autowired
    RecordServiceImpl recordService;

    @Test
    void contextLoads() {
//        RecordEntity recordEntity = new RecordEntity();
////        recordEntity.setArticleId(111L);
////        recordEntity.setUserId(222L);
////        recordEntity.setCreateTime(new Date());
////        System.out.println(recordService.save(recordEntity));
        List<RecordEntity> list = recordService.list();
        System.out.println(list);
    }

}
