package com.laijiantian.zce.user.entity;

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
 * @date 2021-03-23 22:45:02
 */
@Data
@TableName("user_info_record")
public class UserInfoRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 关注数
	 */
	private Integer userFollow;
	/**
	 * 文章数
	 */
	private Integer userArticle;
	/**
	 * 粉丝数
	 */
	private Integer userFan;
	/**
	 * 点赞数
	 */
	private Integer userLike;
	/**
	 * 收藏数
	 */
	private Integer userCollect;
	/**
	 * 参与众测数
	 */
	private Integer userTest;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
