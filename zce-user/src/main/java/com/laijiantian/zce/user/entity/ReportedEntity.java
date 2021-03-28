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
@TableName("ums_reported")
public class ReportedEntity implements Serializable {
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
	 * 举报实体id
	 */
	private Long reportedId;
	/**
	 * 举报类型（0-用户、1-文章、2-评论）
	 */
	private Integer reportedType;
	/**
	 * 举报原因
	 */
	private Integer reportedCode;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 处理类型（0-未处理、1-忽略、2-已处理）
	 */
	private Integer handleType;

}
