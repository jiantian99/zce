package com.laijiantian.zce.article.entity;

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
 * @date 2021-03-27 17:23:19
 */
@Data
@TableName("ams_tag")
public class TagEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 标签id
	 */
	private Long tagId;
	/**
	 * 标签名
	 */
	private String tagName;
	/**
	 * 创建人id
	 */
	private Long userId;
	/**
	 * 引用数
	 */
	private Integer quotes;
	/**
	 * 关注数
	 */
	private Integer follows;
	/**
	 * 是否删除
	 */
	private Integer isDelete;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
