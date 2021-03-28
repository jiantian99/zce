package com.laijiantian.zce.test.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.test.dao.ScorePictureDao;
import com.laijiantian.zce.test.entity.ScorePictureEntity;
import com.laijiantian.zce.test.service.ScorePictureService;


@Service("scorePictureService")
public class ScorePictureServiceImpl extends ServiceImpl<ScorePictureDao, ScorePictureEntity> implements ScorePictureService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ScorePictureEntity> page = this.page(
                new Query<ScorePictureEntity>().getPage(params),
                new QueryWrapper<ScorePictureEntity>()
        );

        return new PageUtils(page);
    }

}