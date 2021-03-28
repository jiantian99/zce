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

import com.laijiantian.zce.user.entity.CodeEntity;
import com.laijiantian.zce.user.service.CodeService;
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
@RequestMapping("user/code")
public class CodeController {
    @Autowired
    private CodeService codeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("user:code:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = codeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("user:code:info")
    public R info(@PathVariable("id") Integer id){
		CodeEntity code = codeService.getById(id);

        return R.ok().put("code", code);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("user:code:save")
    public R save(@RequestBody CodeEntity code){
		codeService.save(code);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("user:code:update")
    public R update(@RequestBody CodeEntity code){
		codeService.updateById(code);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("user:code:delete")
    public R delete(@RequestBody Integer[] ids){
		codeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
