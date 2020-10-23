package com.wfuhui.modules.market.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.market.entity.ActivityJoinEntity;

/**
 * 活动报名
 * 

 */
public interface ActivityJoinService {
	
	ActivityJoinEntity queryObject(Integer id);
	
	List<ActivityJoinEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ActivityJoinEntity activityJoin);
	
	void update(ActivityJoinEntity activityJoin);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	void changestatus(Integer id);

	void changestatusBatch(Integer[] ids);
	
	ActivityJoinEntity query(Integer activityId, Integer userId);

	List<ActivityJoinEntity> queryMyjoin(Integer userId);

	ActivityJoinEntity query(Integer activityId, String mobile);
}
