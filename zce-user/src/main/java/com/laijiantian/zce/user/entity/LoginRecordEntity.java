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
 * @date 2021-03-23 22:45:03
 */
@Data
@TableName("ums_login_record")
public class LoginRecordEntity implements Serializable {
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
	 * 登录时间
	 */
	private Date loginTime;
	/**
	 * UA
	 */
	private String userAgent;
	/**
	 * IP地址
	 */
	private String loginIp;
	/**
	 * 城市
	 */
	private String loginCity;
	/**
	 * 登录类型（0-PC端，1-移动端）
	 */
	private Integer loginType;

}
