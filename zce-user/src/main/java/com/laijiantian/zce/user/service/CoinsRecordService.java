package com.laijiantian.zce.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.zce.user.entity.CoinsRecordEntity;

import java.util.Map;

/**
 * 用户硬币记录
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 22:45:03
 */
public interface CoinsRecordService extends IService<CoinsRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

