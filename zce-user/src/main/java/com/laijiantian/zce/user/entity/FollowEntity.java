package com.laijiantian.zce.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户关注实体
 * 
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 22:45:03
 */
@Data
@TableName("ums_follow")
public class FollowEntity implements Serializable {
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
	 * 关注实体id
	 */
	private Long followId;
	/**
	 * 关注类型（0-关注用户、1-收藏文章、2-关注标签）
	 */
	private Integer followType;
	/**
	 * 是否关注
	 */
	private Integer isFollow;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
