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

import com.laijiantian.zce.user.entity.GrowthEntity;
import com.laijiantian.zce.user.service.GrowthService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.R;



/**
 * 
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 23:30:39
 */
@RestController
@RequestMapping("user/growth")
public class GrowthController {
    @Autowired
    private GrowthService growthService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:growth:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = growthService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:growth:info")
    public R info(@PathVariable("id") Integer id){
		GrowthEntity growth = growthService.getById(id);

        return R.ok().put("growth", growth);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:growth:save")
    public R save(@RequestBody GrowthEntity growth){
		growthService.save(growth);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:growth:update")
    public R update(@RequestBody GrowthEntity growth){
		growthService.updateById(growth);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:growth:delete")
    public R delete(@RequestBody Integer[] ids){
		growthService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
