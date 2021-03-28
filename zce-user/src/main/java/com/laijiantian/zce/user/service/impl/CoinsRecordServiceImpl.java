package com.laijiantian.zce.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.user.dao.CoinsRecordDao;
import com.laijiantian.zce.user.entity.CoinsRecordEntity;
import com.laijiantian.zce.user.service.CoinsRecordService;


@Service("coinsRecordService")
public class CoinsRecordServiceImpl extends ServiceImpl<CoinsRecordDao, CoinsRecordEntity> implements CoinsRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CoinsRecordEntity> page = this.page(
                new Query<CoinsRecordEntity>().getPage(params),
                new QueryWrapper<CoinsRecordEntity>()
        );

        return new PageUtils(page);
    }

}