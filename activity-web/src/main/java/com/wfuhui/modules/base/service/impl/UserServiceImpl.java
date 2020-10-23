package com.wfuhui.modules.base.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfuhui.modules.base.dao.UserDao;
import com.wfuhui.modules.base.entity.UserEntity;
import com.wfuhui.modules.base.service.UserService;



@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserEntity queryObject(Long id){
		return userDao.queryObject(id);
	}
	
	@Override
	public List<UserEntity> queryList(Map<String, Object> map){
		return userDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDao.queryTotal(map);
	}
	
	@Override
	public void save(UserEntity user){
		userDao.save(user);
	}
	
	@Override
	public void update(UserEntity user){
		userDao.update(user);
	}
	
	@Override
	public void delete(Long id){
		userDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		userDao.deleteBatch(ids);
	}

	@Override
	public UserEntity queryByOpenid(String openid) {
		return userDao.queryByOpenid(openid);
	}

	@Override
	public UserEntity queryByLoginName(String loginName) {
		return userDao.queryByLoginName(loginName);
	}
}
