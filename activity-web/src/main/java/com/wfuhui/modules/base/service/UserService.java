package com.wfuhui.modules.base.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.base.entity.UserEntity;

/**

 */
public interface UserService {
	
	UserEntity queryObject(Long id);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserEntity user);
	
	void update(UserEntity user);
	
	void delete(Long id);
	
	void deleteBatch(Integer[] ids);

	UserEntity queryByOpenid(String openid);

	UserEntity queryByLoginName(String loginName);
}
