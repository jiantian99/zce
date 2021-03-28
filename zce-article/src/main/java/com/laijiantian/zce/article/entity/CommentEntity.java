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
@TableName("ams_comment")
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 评论id
	 */
	private Long commentId;
	/**
	 * 文章id
	 */
	private Long articleId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 评论id
	 */
	private String commentContent;
	/**
	 * 评论点赞数
	 */
	private Integer commentStart;
	/**
	 * 评论回复数
	 */
	private Integer commentReplie;
	/**
	 * 算法评分
	 */
	private Double commentSocre;
	/**
	 * 算法删除
	 */
	private Integer isDelete;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
