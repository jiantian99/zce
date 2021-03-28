package com.laijiantian.zce.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.user.dao.LoginTokenDao;
import com.laijiantian.zce.user.entity.LoginTokenEntity;
import com.laijiantian.zce.user.service.LoginTokenService;


@Service("loginTokenService")
public class LoginTokenServiceImpl extends ServiceImpl<LoginTokenDao, LoginTokenEntity> implements LoginTokenService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LoginTokenEntity> page = this.page(
                new Query<LoginTokenEntity>().getPage(params),
                new QueryWrapper<LoginTokenEntity>()
        );

        return new PageUtils(page);
    }

}