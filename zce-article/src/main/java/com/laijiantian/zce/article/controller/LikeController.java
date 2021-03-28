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

import com.laijiantian.zce.article.entity.LikeEntity;
import com.laijiantian.zce.article.service.LikeService;
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
@RequestMapping("article/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("article:like:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = likeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("article:like:info")
    public R info(@PathVariable("id") Long id){
		LikeEntity like = likeService.getById(id);

        return R.ok().put("like", like);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("article:like:save")
    public R save(@RequestBody LikeEntity like){
		likeService.save(like);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("article:like:update")
    public R update(@RequestBody LikeEntity like){
		likeService.updateById(like);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("article:like:delete")
    public R delete(@RequestBody Long[] ids){
		likeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
