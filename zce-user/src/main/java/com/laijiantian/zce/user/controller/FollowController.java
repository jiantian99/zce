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

import com.laijiantian.zce.user.entity.FollowEntity;
import com.laijiantian.zce.user.service.FollowService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.R;



/**
 * 用户关注实体
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 23:30:39
 */
@RestController
@RequestMapping("user/follow")
public class FollowController {
    @Autowired
    private FollowService followService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:follow:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = followService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:follow:info")
    public R info(@PathVariable("id") Long id){
		FollowEntity follow = followService.getById(id);

        return R.ok().put("follow", follow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:follow:save")
    public R save(@RequestBody FollowEntity follow){
		followService.save(follow);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:follow:update")
    public R update(@RequestBody FollowEntity follow){
		followService.updateById(follow);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:follow:delete")
    public R delete(@RequestBody Long[] ids){
		followService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
