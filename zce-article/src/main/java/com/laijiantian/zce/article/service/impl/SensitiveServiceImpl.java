package com.laijiantian.zce.article.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.article.dao.SensitiveDao;
import com.laijiantian.zce.article.entity.SensitiveEntity;
import com.laijiantian.zce.article.service.SensitiveService;


@Service("sensitiveService")
public class SensitiveServiceImpl extends ServiceImpl<SensitiveDao, SensitiveEntity> implements SensitiveService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SensitiveEntity> page = this.page(
                new Query<SensitiveEntity>().getPage(params),
                new QueryWrapper<SensitiveEntity>()
        );

        return new PageUtils(page);
    }

}