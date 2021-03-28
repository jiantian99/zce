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
@TableName("ums_sign_record")
public class SignRecordEntity implements Serializable {
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
	 * 签到时间
	 */
	private Date signDate;
	/**
	 * 上次签到时间
	 */
	private Date lastSign;
	/**
	 * 连续签到次数
	 */
	private Integer signTimes;

}
