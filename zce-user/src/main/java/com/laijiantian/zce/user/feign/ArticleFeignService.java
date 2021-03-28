package com.laijiantian.zce.user.feign;

import com.laijiantian.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Lai Jiantian
 * @Date 2021/3/28 15:37
 * @Version 1.0
 */
@FeignClient("zce-article")
public interface ArticleFeignService {
    @RequestMapping("/article/article/user/list")
    public R userArticle();
}
