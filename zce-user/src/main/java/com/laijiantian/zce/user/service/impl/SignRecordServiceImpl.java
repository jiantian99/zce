package com.laijiantian.zce.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.user.dao.SignRecordDao;
import com.laijiantian.zce.user.entity.SignRecordEntity;
import com.laijiantian.zce.user.service.SignRecordService;


@Service("signRecordService")
public class SignRecordServiceImpl extends ServiceImpl<SignRecordDao, SignRecordEntity> implements SignRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SignRecordEntity> page = this.page(
                new Query<SignRecordEntity>().getPage(params),
                new QueryWrapper<SignRecordEntity>()
        );

        return new PageUtils(page);
    }

}