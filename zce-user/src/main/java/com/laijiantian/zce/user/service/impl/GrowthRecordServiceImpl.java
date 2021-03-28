package com.laijiantian.zce.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.user.dao.GrowthRecordDao;
import com.laijiantian.zce.user.entity.GrowthRecordEntity;
import com.laijiantian.zce.user.service.GrowthRecordService;


@Service("growthRecordService")
public class GrowthRecordServiceImpl extends ServiceImpl<GrowthRecordDao, GrowthRecordEntity> implements GrowthRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GrowthRecordEntity> page = this.page(
                new Query<GrowthRecordEntity>().getPage(params),
                new QueryWrapper<GrowthRecordEntity>()
        );

        return new PageUtils(page);
    }

}