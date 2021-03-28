package com.laijiantian.zce.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.user.dao.UserInfoRecordDao;
import com.laijiantian.zce.user.entity.UserInfoRecordEntity;
import com.laijiantian.zce.user.service.UserInfoRecordService;


@Service("userInfoRecordService")
public class UserInfoRecordServiceImpl extends ServiceImpl<UserInfoRecordDao, UserInfoRecordEntity> implements UserInfoRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserInfoRecordEntity> page = this.page(
                new Query<UserInfoRecordEntity>().getPage(params),
                new QueryWrapper<UserInfoRecordEntity>()
        );

        return new PageUtils(page);
    }

}