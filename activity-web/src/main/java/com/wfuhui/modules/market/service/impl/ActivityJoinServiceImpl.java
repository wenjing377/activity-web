package com.wfuhui.modules.market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfuhui.modules.market.dao.ActivityJoinDao;
import com.wfuhui.modules.market.entity.ActivityJoinEntity;
import com.wfuhui.modules.market.service.ActivityJoinService;



@Service("activityJoinService")
public class ActivityJoinServiceImpl implements ActivityJoinService {
	@Autowired
	private ActivityJoinDao activityJoinDao;
	
	@Override
	public ActivityJoinEntity queryObject(Integer id){
		return activityJoinDao.queryObject(id);
	}
	
	@Override
	public List<ActivityJoinEntity> queryList(Map<String, Object> map){
		return activityJoinDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return activityJoinDao.queryTotal(map);
	}
	
	@Override
	public void save(ActivityJoinEntity activityJoin){
		activityJoinDao.save(activityJoin);
	}
	
	@Override
	public void update(ActivityJoinEntity activityJoin){
		activityJoinDao.update(activityJoin);
	}
	
	@Override
	public void delete(Integer id){
		activityJoinDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		activityJoinDao.deleteBatch(ids);
	}
	@Override
	public void changestatus(Integer id){
		activityJoinDao.changestatus(id);
	}

	@Override
	public void changestatusBatch(Integer[] ids){
		activityJoinDao.changestatusBatch(ids);
	}
	
	@Override
	public ActivityJoinEntity query(Integer activityId, Integer userId) {
		return activityJoinDao.query(activityId, userId);
	}

	@Override
	public List<ActivityJoinEntity> queryMyjoin(Integer userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("memberId", userId);
		return activityJoinDao.queryList(params);
	}

	@Override
	public ActivityJoinEntity query(Integer activityId, String mobile) {
		return activityJoinDao.queryByMobile(activityId, mobile);
	}
}
