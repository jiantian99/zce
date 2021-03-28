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
 * @date 2021-03-27 17:58:33
 */
@Data
@TableName("tms_score")
public class ScoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 产品id
	 */
	private Long pId;
	/**
	 * 评分id
	 */
	private Long scoreId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 星星数(0-5)
	 */
	private Integer star;
	/**
	 * 优点
	 */
	private String advantage;
	/**
	 * 缺点
	 */
	private String disadvantage;
	/**
	 * 总结
	 */
	private String summary;
	/**
	 * UA
	 */
	private String userAgent;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 是否删除
	 */
	private Integer isDelete;

}
