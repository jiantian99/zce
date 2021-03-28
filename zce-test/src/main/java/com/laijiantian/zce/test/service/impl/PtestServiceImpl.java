package com.laijiantian.zce.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.test.dao.PtestDao;
import com.laijiantian.zce.test.entity.PtestEntity;
import com.laijiantian.zce.test.service.PtestService;


@Service("ptestService")
public class PtestServiceImpl extends ServiceImpl<PtestDao, PtestEntity> implements PtestService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PtestEntity> page = this.page(
                new Query<PtestEntity>().getPage(params),
                new QueryWrapper<PtestEntity>()
        );

        return new PageUtils(page);
    }

}