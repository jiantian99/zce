package com.laijiantian.zce.user.dao;

import com.laijiantian.zce.user.entity.FollowEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户关注实体
 * 
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 22:45:03
 */
@Mapper
public interface FollowDao extends BaseMapper<FollowEntity> {
	
}
