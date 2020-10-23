package com.wfuhui.modules.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wfuhui.modules.sys.dao.BaseDao;
import com.wfuhui.modules.market.entity.ActivityEntity;
import com.wfuhui.modules.market.entity.ActivityJoinEntity;

/**
 * 活动报名

 */
@Mapper
public interface ActivityJoinDao extends BaseDao<ActivityJoinEntity> {
	ActivityJoinEntity query(@Param("activityId")Integer activityId, @Param("memberId")Integer memberId);

	List<ActivityEntity> queryByMemberId(Integer memberId);

	ActivityJoinEntity queryByMobile(@Param("activityId")Integer activityId, @Param("mobile")String mobile);
}
