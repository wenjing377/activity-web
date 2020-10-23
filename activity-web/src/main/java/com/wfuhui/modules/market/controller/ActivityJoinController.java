package com.wfuhui.modules.market.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.market.entity.ActivityJoinEntity;
import com.wfuhui.modules.market.service.ActivityJoinService;
import com.wfuhui.modules.sys.controller.AbstractController;


/**
 * 活动报名

 */
@RestController
@RequestMapping("activityjoin")
public class ActivityJoinController extends AbstractController {
	@Autowired
	private ActivityJoinService activityJoinService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("activityjoin:list")
	public R list(@RequestParam Map<String, Object> params){
		params.put("storeId", getUserId());
		//查询列表数据
        Query query = new Query(params);

		List<ActivityJoinEntity> activityJoinList = activityJoinService.queryList(query);
		int total = activityJoinService.queryTotal(query);
		
		return R.ok().put("rows", activityJoinList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("activityjoin:info")
	public R info(@PathVariable("id") Integer id){
		ActivityJoinEntity activityJoin = activityJoinService.queryObject(id);
		
		return R.ok().put("activityJoin", activityJoin);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("activityjoin:save")
	public R save(@RequestBody ActivityJoinEntity activityJoin){
		activityJoinService.save(activityJoin);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("activityjoin:update")
	public R update(@RequestBody ActivityJoinEntity activityJoin){
		activityJoinService.update(activityJoin);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("activityjoin:delete")
	public R delete(@RequestBody Integer[] ids){
		activityJoinService.deleteBatch(ids);
		
		return R.ok();
	}

}
