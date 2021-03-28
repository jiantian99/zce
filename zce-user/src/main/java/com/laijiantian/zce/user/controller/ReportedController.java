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

import com.laijiantian.zce.user.entity.ReportedEntity;
import com.laijiantian.zce.user.service.ReportedService;
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
@RequestMapping("user/reported")
public class ReportedController {
    @Autowired
    private ReportedService reportedService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:reported:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = reportedService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:reported:info")
    public R info(@PathVariable("id") Long id){
		ReportedEntity reported = reportedService.getById(id);

        return R.ok().put("reported", reported);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:reported:save")
    public R save(@RequestBody ReportedEntity reported){
		reportedService.save(reported);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:reported:update")
    public R update(@RequestBody ReportedEntity reported){
		reportedService.updateById(reported);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:reported:delete")
    public R delete(@RequestBody Long[] ids){
		reportedService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
