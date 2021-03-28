package com.laijiantian.zce.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * 
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 22:45:02
 */
@Data
@TableName("ums_user")
public class UserEntity implements Serializable {
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
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 身份证号码
	 */
	private Integer idNumber;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 头像
	 */
	private String header;
	/**
	 * 个人简介
	 */
	private String sign;
	/**
	 * 性别
	 */
	private Integer gender;
	/**
	 * 硬币
	 */
	private Integer coin;
	/**
	 * 成长值
	 */
	private Integer growth;
	/**
	 * 用户类型
	 */
	private Integer userType;
	/**
	 * 用户状态
	 */
	private Integer userStatus;
	/**
	 * 注册时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
