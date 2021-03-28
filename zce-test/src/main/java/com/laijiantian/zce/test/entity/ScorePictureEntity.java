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
@TableName("tms_score_picture")
public class ScorePictureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	@TableId
	private Long id;
	/**
	 * 分数id
	 */
	private Long scoreId;
	/**
	 * 图片外链
	 */
	private String picUrl;
	/**
	 * 图片位置
	 */
	private Integer picLocation;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
