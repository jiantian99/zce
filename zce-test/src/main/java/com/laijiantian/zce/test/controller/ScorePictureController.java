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

import com.laijiantian.zce.test.entity.ScorePictureEntity;
import com.laijiantian.zce.test.service.ScorePictureService;
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
@RequestMapping("test/scorepicture")
public class ScorePictureController {
    @Autowired
    private ScorePictureService scorePictureService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("test:scorepicture:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = scorePictureService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("test:scorepicture:info")
    public R info(@PathVariable("id") Long id){
		ScorePictureEntity scorePicture = scorePictureService.getById(id);

        return R.ok().put("scorePicture", scorePicture);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("test:scorepicture:save")
    public R save(@RequestBody ScorePictureEntity scorePicture){
		scorePictureService.save(scorePicture);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("test:scorepicture:update")
    public R update(@RequestBody ScorePictureEntity scorePicture){
		scorePictureService.updateById(scorePicture);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("test:scorepicture:delete")
    public R delete(@RequestBody Long[] ids){
		scorePictureService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
