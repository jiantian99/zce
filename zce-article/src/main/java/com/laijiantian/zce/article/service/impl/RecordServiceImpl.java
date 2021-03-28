package com.laijiantian.zce.article.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.article.dao.RecordDao;
import com.laijiantian.zce.article.entity.RecordEntity;
import com.laijiantian.zce.article.service.RecordService;


@Service("recordService")
public class RecordServiceImpl extends ServiceImpl<RecordDao, RecordEntity> implements RecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RecordEntity> page = this.page(
                new Query<RecordEntity>().getPage(params),
                new QueryWrapper<RecordEntity>()
        );

        return new PageUtils(page);
    }

}