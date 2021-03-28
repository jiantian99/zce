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

import com.laijiantian.zce.article.entity.ArticleTagEntity;
import com.laijiantian.zce.article.service.ArticleTagService;
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
@RequestMapping("article/articletag")
public class ArticleTagController {
    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("article:articletag:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = articleTagService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("article:articletag:info")
    public R info(@PathVariable("id") Long id){
		ArticleTagEntity articleTag = articleTagService.getById(id);

        return R.ok().put("articleTag", articleTag);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("article:articletag:save")
    public R save(@RequestBody ArticleTagEntity articleTag){
		articleTagService.save(articleTag);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("article:articletag:update")
    public R update(@RequestBody ArticleTagEntity articleTag){
		articleTagService.updateById(articleTag);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("article:articletag:delete")
    public R delete(@RequestBody Long[] ids){
		articleTagService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
