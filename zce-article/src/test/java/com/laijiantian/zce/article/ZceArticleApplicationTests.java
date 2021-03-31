package com.laijiantian.zce.article;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.laijiantian.zce.article.entity.RecordEntity;
import com.laijiantian.zce.article.entity.TagEntity;
import com.laijiantian.zce.article.service.RecordService;
import com.laijiantian.zce.article.service.impl.RecordServiceImpl;
import com.laijiantian.zce.article.service.impl.TagServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ZceArticleApplicationTests {

    @Autowired
    RecordServiceImpl recordService;

    @Autowired
    TagServiceImpl tagService;

    @Test
    void contextLoads() {
        for (int i = 0; i < 5; i++) {
            TagEntity tagEntity = new TagEntity();
            // 雪花id
            Snowflake tagId = IdUtil.createSnowflake(2, 1);
            Snowflake userId = IdUtil.createSnowflake(2, 1);
            tagEntity.setTagId(tagId.nextId());
            tagEntity.setUserId(userId.nextId());
            tagEntity.setTagName("测试"+ RandomUtil.randomInt(0,100));
            tagEntity.setCreateTime(new Date());
            System.out.println(tagService.save(tagEntity));
        }
    }

}
