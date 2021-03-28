package com.laijiantian.zce.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.test.dao.ParticipationDao;
import com.laijiantian.zce.test.entity.ParticipationEntity;
import com.laijiantian.zce.test.service.ParticipationService;


@Service("participationService")
public class ParticipationServiceImpl extends ServiceImpl<ParticipationDao, ParticipationEntity> implements ParticipationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParticipationEntity> page = this.page(
                new Query<ParticipationEntity>().getPage(params),
                new QueryWrapper<ParticipationEntity>()
        );

        return new PageUtils(page);
    }

}