package com.laijiantian.zce.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.zce.user.entity.SignRecordEntity;

import java.util.Map;

/**
 * 
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 22:45:02
 */
public interface SignRecordService extends IService<SignRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

