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
@TableName("tms_ptest")
public class PtestEntity implements Serializable {
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
	 * 众测标题
	 */
	private String ptestTitle;
	/**
	 * 众测内容
	 */
	private String ptestContent;
	/**
	 * 发起人id
	 */
	private Long sponserId;
	/**
	 * 参与人数
	 */
	private Integer participantCount;
	/**
	 * 中签数量
	 */
	private Integer prizeCount;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 众测状态（0-正常、1-冻结、2-结束）
	 */
	private Integer publicStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

}
