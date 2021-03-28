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

import com.laijiantian.zce.user.entity.GrowthRecordEntity;
import com.laijiantian.zce.user.service.GrowthRecordService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.R;



/**
 * 用户成长值记录
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 23:30:39
 */
@RestController
@RequestMapping("user/growthrecord")
public class GrowthRecordController {
    @Autowired
    private GrowthRecordService growthRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:growthrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = growthRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:growthrecord:info")
    public R info(@PathVariable("id") Long id){
		GrowthRecordEntity growthRecord = growthRecordService.getById(id);

        return R.ok().put("growthRecord", growthRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:growthrecord:save")
    public R save(@RequestBody GrowthRecordEntity growthRecord){
		growthRecordService.save(growthRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:growthrecord:update")
    public R update(@RequestBody GrowthRecordEntity growthRecord){
		growthRecordService.updateById(growthRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:growthrecord:delete")
    public R delete(@RequestBody Long[] ids){
		growthRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
