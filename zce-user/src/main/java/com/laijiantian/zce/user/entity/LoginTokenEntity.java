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
@TableName("ums_login_token")
public class LoginTokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 用户名
	 */
	private Long userId;
	/**
	 * token
	 */
	private String loginToken;
	/**
	 * 平台标识
	 */
	private Integer loginType;

}
