package com.wfuhui.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 *
 */
public interface BaseDao<T> {
	
	void save(T t);
	
	void save(Map<String, Object> map);
	int Tongguo(Object id);
	int Tongguo(Map<String, Object> map);

	int TongguoBatch(Object[] id);
	int Nopass(Object id);
	int Nopass(Map<String, Object> map);

	int NopassBatch(Object[] id);

	void saveBatch(List<T> list);
	
	int update(T t);
	
	int update(Map<String, Object> map);
	
	int delete(Object id);
	
	int delete(Map<String, Object> map);
	
	int deleteBatch(Object[] id);
	int changestatus(Object id);
	int changestatus(Map<String, Object> map);

	int changestatusBatch(Object[] id);

	T queryObject(Object id);
	
	List<T> queryList(Map<String, Object> map);
	
	List<T> queryList(Object id);
	
	int queryTotal(Map<String, Object> map);

	int queryTotal();
}
