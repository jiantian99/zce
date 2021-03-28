package com.laijiantian.zce.article.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.article.dao.LikeDao;
import com.laijiantian.zce.article.entity.LikeEntity;
import com.laijiantian.zce.article.service.LikeService;


@Service("likeService")
public class LikeServiceImpl extends ServiceImpl<LikeDao, LikeEntity> implements LikeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LikeEntity> page = this.page(
                new Query<LikeEntity>().getPage(params),
                new QueryWrapper<LikeEntity>()
        );

        return new PageUtils(page);
    }

}