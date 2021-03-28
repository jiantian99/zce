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

import com.laijiantian.zce.test.entity.ReportEntity;
import com.laijiantian.zce.test.service.ReportService;
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
@RequestMapping("test/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("test:report:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = reportService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("test:report:info")
    public R info(@PathVariable("id") Long id){
		ReportEntity report = reportService.getById(id);

        return R.ok().put("report", report);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("test:report:save")
    public R save(@RequestBody ReportEntity report){
		reportService.save(report);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("test:report:update")
    public R update(@RequestBody ReportEntity report){
		reportService.updateById(report);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("test:report:delete")
    public R delete(@RequestBody Long[] ids){
		reportService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
