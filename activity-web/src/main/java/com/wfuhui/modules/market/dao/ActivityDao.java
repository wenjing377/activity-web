package com.wfuhui.modules.market.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.modules.sys.dao.BaseDao;
import com.wfuhui.modules.market.entity.ActivityEntity;

/**
 * 活动

 */
@Mapper
public interface ActivityDao extends BaseDao<ActivityEntity> {

	ActivityEntity queryOne(Map<String, Object> params);
	
}
