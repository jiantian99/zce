package com.laijiantian.zce.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.zce.user.entity.GrowthRecordEntity;

import java.util.Map;

/**
 * 用户成长值记录
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 22:45:03
 */
public interface GrowthRecordService extends IService<GrowthRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

