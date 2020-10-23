package com.wfuhui.modules.base.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.modules.base.entity.UserEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**

 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

	UserEntity queryByOpenid(String openid);

	UserEntity queryByLoginName(String loginName);
}
