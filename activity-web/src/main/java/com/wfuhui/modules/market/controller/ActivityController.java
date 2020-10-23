package com.wfuhui.modules.market.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.market.entity.ActivityEntity;
import com.wfuhui.modules.market.service.ActivityService;
import com.wfuhui.modules.sys.controller.AbstractController;




/**
 * 活动

 */
@RestController
@RequestMapping("activity")
public class ActivityController extends AbstractController{
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping("/listAll")
	@RequiresPermissions("activity:list")
	public R listAll() {
		List<ActivityEntity> activityList = activityService.queryList(null);
		return R.ok().put("activityList", activityList);
	}
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("activity:list")
	public R list(@RequestParam Map<String, Object> params){
		params.put("storeId", getUserId());
		//查询列表数据
        Query query = new Query(params);

		List<ActivityEntity> activityList = activityService.queryList(query);
		int total = activityService.queryTotal(query);
		
		return R.ok().put("rows", activityList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("activity:info")
	public R info(@PathVariable("id") Integer id){
		ActivityEntity activity = activityService.queryObject(id);
		
		return R.ok().put("activity", activity);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("activity:save")
	public R save(@RequestBody ActivityEntity activity){
		activity.setCreateTime(new Date());
		activity.setStoreId(getUserId());
		activityService.save(activity);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("activity:update")
	public R update(@RequestBody ActivityEntity activity){
		activityService.update(activity);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("activity:delete")
	public R delete(@RequestBody Integer[] ids){
		activityService.deleteBatch(ids);
		
		return R.ok();
	}

	@RequestMapping("/changestatus")
	public R changestatus(@RequestBody Integer[] ids){
		activityService.changestatusBatch(ids);

		return R.ok();
	}
	
}
