package com.laijiantian.zce.article.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-27 17:23:19
 */
@Data
@TableName("ams_like")
public class LikeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 文章id
	 */
	private Long articleId;
	/**
	 * 被点赞人id
	 */
	private Long likedUserId;
	/**
	 * 点赞人id
	 */
	private Long userId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 是否点赞
	 */
	private Integer isLike;

}
