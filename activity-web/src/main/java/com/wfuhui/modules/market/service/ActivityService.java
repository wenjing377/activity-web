package com.wfuhui.modules.market.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.market.entity.ActivityEntity;

/**
 * 活动

 */
public interface ActivityService {
	
	ActivityEntity queryObject(Integer id);
	
	List<ActivityEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	void Tongguo(Integer id);

	void TongguoBatch(Integer[] ids);
	void Nopass(Integer id);

	void NopassBatch(Integer[] ids);
	void save(ActivityEntity activity);
	
	void update(ActivityEntity activity);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	void changestatus(Integer id);

	void changestatusBatch(Integer[] ids);

	ActivityEntity queryOne(Map<String, Object> params);
}
