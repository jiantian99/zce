package com.laijiantian.zce.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.test.dao.ReportDao;
import com.laijiantian.zce.test.entity.ReportEntity;
import com.laijiantian.zce.test.service.ReportService;


@Service("reportService")
public class ReportServiceImpl extends ServiceImpl<ReportDao, ReportEntity> implements ReportService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReportEntity> page = this.page(
                new Query<ReportEntity>().getPage(params),
                new QueryWrapper<ReportEntity>()
        );

        return new PageUtils(page);
    }

}