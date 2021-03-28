package com.laijiantian.zce.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.test.dao.LotteryDao;
import com.laijiantian.zce.test.entity.LotteryEntity;
import com.laijiantian.zce.test.service.LotteryService;


@Service("lotteryService")
public class LotteryServiceImpl extends ServiceImpl<LotteryDao, LotteryEntity> implements LotteryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LotteryEntity> page = this.page(
                new Query<LotteryEntity>().getPage(params),
                new QueryWrapper<LotteryEntity>()
        );

        return new PageUtils(page);
    }

}