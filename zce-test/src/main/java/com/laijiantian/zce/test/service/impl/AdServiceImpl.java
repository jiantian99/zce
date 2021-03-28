package com.laijiantian.zce.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.test.dao.AdDao;
import com.laijiantian.zce.test.entity.AdEntity;
import com.laijiantian.zce.test.service.AdService;


@Service("adService")
public class AdServiceImpl extends ServiceImpl<AdDao, AdEntity> implements AdService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdEntity> page = this.page(
                new Query<AdEntity>().getPage(params),
                new QueryWrapper<AdEntity>()
        );

        return new PageUtils(page);
    }

}