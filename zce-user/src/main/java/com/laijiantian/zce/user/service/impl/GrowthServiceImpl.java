package com.laijiantian.zce.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.user.dao.GrowthDao;
import com.laijiantian.zce.user.entity.GrowthEntity;
import com.laijiantian.zce.user.service.GrowthService;


@Service("growthService")
public class GrowthServiceImpl extends ServiceImpl<GrowthDao, GrowthEntity> implements GrowthService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GrowthEntity> page = this.page(
                new Query<GrowthEntity>().getPage(params),
                new QueryWrapper<GrowthEntity>()
        );

        return new PageUtils(page);
    }

}