package com.laijiantian.zce.article.controller;

import java.util.Arrays;
import java.util.Map;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laijiantian.zce.article.entity.SensitiveEntity;
import com.laijiantian.zce.article.service.SensitiveService;
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
@RequestMapping("article/sensitive")
public class SensitiveController {
    @Autowired
    private SensitiveService sensitiveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("article:sensitive:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sensitiveService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("article:sensitive:info")
    public R info(@PathVariable("id") Integer id){
		SensitiveEntity sensitive = sensitiveService.getById(id);

        return R.ok().put("sensitive", sensitive);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("article:sensitive:save")
    public R save(@RequestBody SensitiveEntity sensitive){
		sensitiveService.save(sensitive);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("article:sensitive:update")
    public R update(@RequestBody SensitiveEntity sensitive){
		sensitiveService.updateById(sensitive);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("article:sensitive:delete")
    public R delete(@RequestBody Integer[] ids){
		sensitiveService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
