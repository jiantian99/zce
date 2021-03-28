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

import com.laijiantian.zce.test.entity.AdEntity;
import com.laijiantian.zce.test.service.AdService;
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
@RequestMapping("test/ad")
public class AdController {
    @Autowired
    private AdService adService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("test:ad:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = adService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("test:ad:info")
    public R info(@PathVariable("id") Long id){
		AdEntity ad = adService.getById(id);

        return R.ok().put("ad", ad);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("test:ad:save")
    public R save(@RequestBody AdEntity ad){
		adService.save(ad);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("test:ad:update")
    public R update(@RequestBody AdEntity ad){
		adService.updateById(ad);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("test:ad:delete")
    public R delete(@RequestBody Long[] ids){
		adService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
