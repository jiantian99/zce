package com.laijiantian.zce.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.zce.test.entity.PtestEntity;

import java.util.Map;

/**
 * 
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-27 17:58:32
 */
public interface PtestService extends IService<PtestEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

