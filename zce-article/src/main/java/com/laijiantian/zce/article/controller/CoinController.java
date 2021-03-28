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

import com.laijiantian.zce.article.entity.CoinEntity;
import com.laijiantian.zce.article.service.CoinService;
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
@RequestMapping("article/coin")
public class CoinController {
    @Autowired
    private CoinService coinService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("article:coin:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = coinService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("article:coin:info")
    public R info(@PathVariable("id") Integer id){
		CoinEntity coin = coinService.getById(id);

        return R.ok().put("coin", coin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("article:coin:save")
    public R save(@RequestBody CoinEntity coin){
		coinService.save(coin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("article:coin:update")
    public R update(@RequestBody CoinEntity coin){
		coinService.updateById(coin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("article:coin:delete")
    public R delete(@RequestBody Integer[] ids){
		coinService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
