package com.laijiantian.zce.article.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.article.dao.ReplyCommentDao;
import com.laijiantian.zce.article.entity.ReplyCommentEntity;
import com.laijiantian.zce.article.service.ReplyCommentService;


@Service("replyCommentService")
public class ReplyCommentServiceImpl extends ServiceImpl<ReplyCommentDao, ReplyCommentEntity> implements ReplyCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReplyCommentEntity> page = this.page(
                new Query<ReplyCommentEntity>().getPage(params),
                new QueryWrapper<ReplyCommentEntity>()
        );

        return new PageUtils(page);
    }

}