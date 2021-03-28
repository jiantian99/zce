package com.laijiantian.zce.user.dao;

import com.laijiantian.zce.user.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author laijiantian
 * @email 872286055@qq.com
 * @date 2021-03-23 22:45:02
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
