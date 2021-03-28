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
@TableName("ams_article")
public class ArticleEntity implements Serializable {
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
	 * 文章标题
	 */
	private String articleTitle;
	/**
	 * 文章内容
	 */
	private String articleContent;
	/**
	 * 文章封面图
	 */
	private String articleCoverPicture;
	/**
	 * 是否置顶（0-否、1-是）
	 */
	private Integer isTop;
	/**
	 * 阅读量
	 */
	private Integer articleReadingCount;
	/**
	 * 评论数
	 */
	private Integer articleCommentCount;
	/**
	 * 点赞数
	 */
	private Integer articleLikeCount;
	/**
	 * 硬币数
	 */
	private Integer articleCoinCount;
	/**
	 * 收藏数
	 */
	private Integer articleCollectCount;
	/**
	 * 作者id
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 作者头像
	 */
	private String userHead;
	/**
	 * 算法评分
	 */
	private Double articleScore;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 文章状态
	 */
	private Integer articleStatus;

}
