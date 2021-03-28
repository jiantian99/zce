package com.laijiantian.zce.user.controller;

import java.util.Arrays;
import java.util.Map;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laijiantian.zce.user.entity.CoinsRecordEntity;
import com.laijiantian.zce.user.service.CoinsRecordService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.R;



/**
 * 用户硬币记录
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 23:30:39
 */
@RestController
@RequestMapping("user/coinsrecord")
public class CoinsRecordController {
    @Autowired
    private CoinsRecordService coinsRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:coinsrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = coinsRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:coinsrecord:info")
    public R info(@PathVariable("id") Long id){
		CoinsRecordEntity coinsRecord = coinsRecordService.getById(id);

        return R.ok().put("coinsRecord", coinsRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:coinsrecord:save")
    public R save(@RequestBody CoinsRecordEntity coinsRecord){
		coinsRecordService.save(coinsRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:coinsrecord:update")
    public R update(@RequestBody CoinsRecordEntity coinsRecord){
		coinsRecordService.updateById(coinsRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:coinsrecord:delete")
    public R delete(@RequestBody Long[] ids){
		coinsRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
