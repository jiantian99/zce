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

import com.laijiantian.zce.user.entity.LoginTokenEntity;
import com.laijiantian.zce.user.service.LoginTokenService;
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
@RequestMapping("user/logintoken")
public class LoginTokenController {
    @Autowired
    private LoginTokenService loginTokenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:logintoken:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = loginTokenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:logintoken:info")
    public R info(@PathVariable("id") Long id){
		LoginTokenEntity loginToken = loginTokenService.getById(id);

        return R.ok().put("loginToken", loginToken);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:logintoken:save")
    public R save(@RequestBody LoginTokenEntity loginToken){
		loginTokenService.save(loginToken);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:logintoken:update")
    public R update(@RequestBody LoginTokenEntity loginToken){
		loginTokenService.updateById(loginToken);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:logintoken:delete")
    public R delete(@RequestBody Long[] ids){
		loginTokenService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
