package com.laijiantian.zce.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.zce.article.entity.LikeEntity;

import java.util.Map;

/**
 * 
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-27 17:23:19
 */
public interface LikeService extends IService<LikeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

