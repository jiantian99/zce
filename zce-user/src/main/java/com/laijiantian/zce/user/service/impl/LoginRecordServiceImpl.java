package com.laijiantian.zce.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.user.dao.LoginRecordDao;
import com.laijiantian.zce.user.entity.LoginRecordEntity;
import com.laijiantian.zce.user.service.LoginRecordService;


@Service("loginRecordService")
public class LoginRecordServiceImpl extends ServiceImpl<LoginRecordDao, LoginRecordEntity> implements LoginRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LoginRecordEntity> page = this.page(
                new Query<LoginRecordEntity>().getPage(params),
                new QueryWrapper<LoginRecordEntity>()
        );

        return new PageUtils(page);
    }

}