package com.laijiantian.zce.article.controller;

import java.util.Arrays;
import java.util.Map;

// import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laijiantian.zce.article.entity.ReplyCommentEntity;
import com.laijiantian.zce.article.service.ReplyCommentService;
import com.laijiantian.common.utils.PageUtils;
import com.laijiantian.common.utils.R;



/**
 * 
 *
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-27 17:23:19
 */
@RestController
@RequestMapping("article/replycomment")
public class ReplyCommentController {
    @Autowired
    private ReplyCommentService replyCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("article:replycomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = replyCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("article:replycomment:info")
    public R info(@PathVariable("id") Long id){
		ReplyCommentEntity replyComment = replyCommentService.getById(id);

        return R.ok().put("replyComment", replyComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("article:replycomment:save")
    public R save(@RequestBody ReplyCommentEntity replyComment){
		replyCommentService.save(replyComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("article:replycomment:update")
    public R update(@RequestBody ReplyCommentEntity replyComment){
		replyCommentService.updateById(replyComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("article:replycomment:delete")
    public R delete(@RequestBody Long[] ids){
		replyCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
