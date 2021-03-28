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

import com.laijiantian.zce.user.entity.UserInfoRecordEntity;
import com.laijiantian.zce.user.service.UserInfoRecordService;
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
@RequestMapping("user/userinforecord")
public class UserInfoRecordController {
    @Autowired
    private UserInfoRecordService userInfoRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:userinforecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userInfoRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:userinforecord:info")
    public R info(@PathVariable("id") Long id){
		UserInfoRecordEntity userInfoRecord = userInfoRecordService.getById(id);

        return R.ok().put("userInfoRecord", userInfoRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:userinforecord:save")
    public R save(@RequestBody UserInfoRecordEntity userInfoRecord){
		userInfoRecordService.save(userInfoRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:userinforecord:update")
    public R update(@RequestBody UserInfoRecordEntity userInfoRecord){
		userInfoRecordService.updateById(userInfoRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:userinforecord:delete")
    public R delete(@RequestBody Long[] ids){
		userInfoRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
