package com.laijiantian.zce.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.user.dao.ReportedDao;
import com.laijiantian.zce.user.entity.ReportedEntity;
import com.laijiantian.zce.user.service.ReportedService;


@Service("reportedService")
public class ReportedServiceImpl extends ServiceImpl<ReportedDao, ReportedEntity> implements ReportedService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReportedEntity> page = this.page(
                new Query<ReportedEntity>().getPage(params),
                new QueryWrapper<ReportedEntity>()
        );

        return new PageUtils(page);
    }

}