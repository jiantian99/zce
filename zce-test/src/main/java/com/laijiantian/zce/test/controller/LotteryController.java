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

import com.laijiantian.zce.test.entity.LotteryEntity;
import com.laijiantian.zce.test.service.LotteryService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.R;



/**
 * 
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-27 17:58:32
 */
@RestController
@RequestMapping("test/lottery")
public class LotteryController {
    @Autowired
    private LotteryService lotteryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("test:lottery:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lotteryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("test:lottery:info")
    public R info(@PathVariable("id") Long id){
		LotteryEntity lottery = lotteryService.getById(id);

        return R.ok().put("lottery", lottery);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("test:lottery:save")
    public R save(@RequestBody LotteryEntity lottery){
		lotteryService.save(lottery);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("test:lottery:update")
    public R update(@RequestBody LotteryEntity lottery){
		lotteryService.updateById(lottery);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("test:lottery:delete")
    public R delete(@RequestBody Long[] ids){
		lotteryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
