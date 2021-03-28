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
@TableName("ums_code")
public class CodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Integer id;
	/**
	 * 邀请码
	 */
	private String code;
	/**
	 * 创建人id
	 */
	private Long userId;
	/**
	 * 邀请码数量
	 */
	private Integer codeCount;
	/**
	 * 邀请码状态（0-使用中，1-冻结，2-使用完）
	 */
	private Integer codeStatus;
	/**
	 * 已使用数量
	 */
	private Integer usedCount;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
