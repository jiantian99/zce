package com.laijiantian.zce.test.controller;

import java.util.Arrays;
import java.util.Map;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laijiantian.zce.test.entity.ScoreEntity;
import com.laijiantian.zce.test.service.ScoreService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.R;



/**
 * 
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-27 17:58:33
 */
@RestController
@RequestMapping("test/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("test:score:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = scoreService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("test:score:info")
    public R info(@PathVariable("id") Long id){
		ScoreEntity score = scoreService.getById(id);

        return R.ok().put("score", score);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("test:score:save")
    public R save(@RequestBody ScoreEntity score){
		scoreService.save(score);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("test:score:update")
    public R update(@RequestBody ScoreEntity score){
		scoreService.updateById(score);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("test:score:delete")
    public R delete(@RequestBody Long[] ids){
		scoreService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
