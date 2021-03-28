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

import com.laijiantian.zce.test.entity.ParticipationEntity;
import com.laijiantian.zce.test.service.ParticipationService;
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
@RequestMapping("test/participation")
public class ParticipationController {
    @Autowired
    private ParticipationService participationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("test:participation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = participationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("test:participation:info")
    public R info(@PathVariable("id") Long id){
		ParticipationEntity participation = participationService.getById(id);

        return R.ok().put("participation", participation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("test:participation:save")
    public R save(@RequestBody ParticipationEntity participation){
		participationService.save(participation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("test:participation:update")
    public R update(@RequestBody ParticipationEntity participation){
		participationService.updateById(participation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("test:participation:delete")
    public R delete(@RequestBody Long[] ids){
		participationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
