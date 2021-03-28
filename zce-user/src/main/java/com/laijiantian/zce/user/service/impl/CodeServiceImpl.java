package com.laijiantian.zce.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.Query;

import com.laijiantian.zce.user.dao.CodeDao;
import com.laijiantian.zce.user.entity.CodeEntity;
import com.laijiantian.zce.user.service.CodeService;


@Service("codeService")
public class CodeServiceImpl extends ServiceImpl<CodeDao, CodeEntity> implements CodeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CodeEntity> page = this.page(
                new Query<CodeEntity>().getPage(params),
                new QueryWrapper<CodeEntity>()
        );

        return new PageUtils(page);
    }

}