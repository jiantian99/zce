package com.laijiantian.zce.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.zce.test.entity.ReportEntity;

import java.util.Map;

/**
 * 
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-27 17:58:33
 */
public interface ReportService extends IService<ReportEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

