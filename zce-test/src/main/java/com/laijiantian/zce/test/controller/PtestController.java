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

import com.laijiantian.zce.test.entity.PtestEntity;
import com.laijiantian.zce.test.service.PtestService;
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
@RequestMapping("test/ptest")
public class PtestController {
    @Autowired
    private PtestService ptestService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("test:ptest:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ptestService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("test:ptest:info")
    public R info(@PathVariable("id") Long id){
		PtestEntity ptest = ptestService.getById(id);

        return R.ok().put("ptest", ptest);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("test:ptest:save")
    public R save(@RequestBody PtestEntity ptest){
		ptestService.save(ptest);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("test:ptest:update")
    public R update(@RequestBody PtestEntity ptest){
		ptestService.updateById(ptest);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("test:ptest:delete")
    public R delete(@RequestBody Long[] ids){
		ptestService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
