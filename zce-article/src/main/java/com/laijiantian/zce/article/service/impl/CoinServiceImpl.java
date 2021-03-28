package com.laijiantian.zce.article.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.article.dao.CoinDao;
import com.laijiantian.zce.article.entity.CoinEntity;
import com.laijiantian.zce.article.service.CoinService;


@Service("coinService")
public class CoinServiceImpl extends ServiceImpl<CoinDao, CoinEntity> implements CoinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CoinEntity> page = this.page(
                new Query<CoinEntity>().getPage(params),
                new QueryWrapper<CoinEntity>()
        );

        return new PageUtils(page);
    }

}