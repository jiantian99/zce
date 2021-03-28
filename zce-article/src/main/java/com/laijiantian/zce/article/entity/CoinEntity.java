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
@TableName("ams_coin")
public class CoinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Integer id;
	/**
	 * 文章id
	 */
	private Long articleId;
	/**
	 * 投币人id
	 */
	private Long outUserId;
	/**
	 * 被投币人id
	 */
	private Long inUserId;
	/**
	 * 投币时间
	 */
	private Date createTime;
	/**
	 * 投币数
	 */
	private Integer coin;

}
