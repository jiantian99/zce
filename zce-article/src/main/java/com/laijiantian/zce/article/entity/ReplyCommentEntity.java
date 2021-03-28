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
@TableName("ams_reply_comment")
public class ReplyCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 回复人id
	 */
	private Long replyUserId;
	/**
	 * 被回复评论id
	 */
	private Long commentId;
	/**
	 * 评论人id
	 */
	private Long repliedUserId;
	/**
	 * 回复内容
	 */
	private String replyContent;
	/**
	 * 是否删除
	 */
	private Integer isDelete;
	/**
	 * 回复时间
	 */
	private Date replyTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
