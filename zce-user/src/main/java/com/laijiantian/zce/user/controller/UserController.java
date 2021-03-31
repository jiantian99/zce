package com.laijiantian.zce.user.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.laijiantian.zce.user.feign.ArticleFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laijiantian.zce.user.entity.UserEntity;
import com.laijiantian.zce.user.service.UserService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.R;



/**
 * 用户表
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 23:30:39
 */
@RefreshScope
@RestController
@RequestMapping("user/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    ArticleFeignService articleFeignService;

    @Value("${user.msg.time}")
    private Integer msgTime;

    @Value("${test.namespace.group}")
    private String group;

    @RequestMapping("/articles")
    public R testFeign(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("张三");
        R userArticle = articleFeignService.userArticle();
        return R.ok().put("user",userEntity).put("articles",userArticle.get("articles"));
    }

    @RequestMapping("/test")
    public R testNacosPro(){
        return R.ok().put("msgTime",msgTime).put("group",group);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:user:info")
    public R info(@PathVariable("id") Long id){
		UserEntity user = userService.getById(id);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:user:save")
    public R save(@RequestBody UserEntity user){
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        String password = user.getPassword();
        if (password.isEmpty()) {
            password= DigestUtil.md5Hex(IdUtil.simpleUUID());
            user.setPassword(password);
        }
//        System.out.println(password);
        user.setUserId(snowflake.nextId());
        user.setCreateTime(new Date());
        userService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:user:update")
    public R update(@RequestBody UserEntity user){
        user.setUpdateTime(new Date());
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:user:delete")
    public R delete(@RequestBody Long[] ids){
		userService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
