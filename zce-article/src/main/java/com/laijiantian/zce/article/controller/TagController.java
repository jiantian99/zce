package com.laijiantian.zce.article.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laijiantian.zce.article.entity.TagEntity;
import com.laijiantian.zce.article.service.TagService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.R;



/**
 * 
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-27 17:23:19
 */
@RestController
@RequestMapping("article/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("article:tag:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tagService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("article:tag:info")
    public R info(@PathVariable("id") Long id){
		TagEntity tag = tagService.getById(id);

        return R.ok().put("tag", tag);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("article:tag:save")
    public R save(@RequestBody TagEntity tag){
        // 雪花id
        Snowflake tagId = IdUtil.createSnowflake(2, 1);
        tag.setTagId(tagId.nextId());
        tag.setCreateTime(new Date());
		tagService.save(tag);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("article:tag:update")
    public R update(@RequestBody TagEntity tag){
        tag.setUpdateTime(new Date());
		tagService.updateById(tag);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("article:tag:delete")
    public R delete(@RequestBody Long[] ids){
		tagService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
