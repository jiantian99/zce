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

import com.laijiantian.zce.user.entity.SignRecordEntity;
import com.laijiantian.zce.user.service.SignRecordService;
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
@RequestMapping("user/signrecord")
public class SignRecordController {
    @Autowired
    private SignRecordService signRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:signrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = signRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:signrecord:info")
    public R info(@PathVariable("id") Long id){
		SignRecordEntity signRecord = signRecordService.getById(id);

        return R.ok().put("signRecord", signRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:signrecord:save")
    public R save(@RequestBody SignRecordEntity signRecord){
		signRecordService.save(signRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:signrecord:update")
    public R update(@RequestBody SignRecordEntity signRecord){
		signRecordService.updateById(signRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:signrecord:delete")
    public R delete(@RequestBody Long[] ids){
		signRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
