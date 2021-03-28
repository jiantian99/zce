package com.laijiantian.zce.test.entity;

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
 * @date 2021-03-27 17:58:32
 */
@Data
@TableName("tms_lottery")
public class LotteryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 众测id
	 */
	private Long ptestId;
	/**
	 * 中签人id
	 */
	private Long userId;
	/**
	 * 抽签时间
	 */
	private Date lotteryTime;
	/**
	 * 报告deadline
	 */
	private Date reportDeadline;
	/**
	 * 中签是否废弃（0-启用，1-废弃）
	 */
	private Integer isDiscard;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
