package com.wfuhui.modules.market.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfuhui.modules.market.dao.ActivityDao;
import com.wfuhui.modules.market.entity.ActivityEntity;
import com.wfuhui.modules.market.service.ActivityService;



@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	private ActivityDao activityDao;
	
	@Override
	public ActivityEntity queryObject(Integer id){
		return activityDao.queryObject(id);
	}
	
	@Override
	public List<ActivityEntity> queryList(Map<String, Object> map){
		return activityDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return activityDao.queryTotal(map);
	}
	
	@Override
	public void save(ActivityEntity activity){
		activityDao.save(activity);
	}
	
	@Override
	public void update(ActivityEntity activity){
		activityDao.update(activity);
	}
	
	@Override
	public void delete(Integer id){
		activityDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		activityDao.deleteBatch(ids);
	}
	@Override
	public void changestatus(Integer id) {activityDao.changestatus(id); }

	@Override
	public void changestatusBatch(Integer[] ids) {activityDao.changestatusBatch(ids); }
	@Override
	public void Tongguo(Integer id) {activityDao.Tongguo(id); }

	@Override
	public void TongguoBatch(Integer[] ids) {activityDao.TongguoBatch(ids); }
	@Override
	public void Nopass(Integer id) {activityDao.Nopass(id); }

	@Override
	public void NopassBatch(Integer[] ids) {activityDao.NopassBatch(ids); }


	@Override
	public ActivityEntity queryOne(Map<String, Object> params) {
		return activityDao.queryOne(params);
	}
	
}
