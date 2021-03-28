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

import com.laijiantian.zce.user.entity.LoginRecordEntity;
import com.laijiantian.zce.user.service.LoginRecordService;
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
@RequestMapping("user/loginrecord")
public class LoginRecordController {
    @Autowired
    private LoginRecordService loginRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:loginrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = loginRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:loginrecord:info")
    public R info(@PathVariable("id") Long id){
		LoginRecordEntity loginRecord = loginRecordService.getById(id);

        return R.ok().put("loginRecord", loginRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:loginrecord:save")
    public R save(@RequestBody LoginRecordEntity loginRecord){
		loginRecordService.save(loginRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:loginrecord:update")
    public R update(@RequestBody LoginRecordEntity loginRecord){
		loginRecordService.updateById(loginRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:loginrecord:delete")
    public R delete(@RequestBody Long[] ids){
		loginRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
