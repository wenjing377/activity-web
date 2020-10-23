package com.wfuhui.modules.market.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.api.annotation.AuthIgnore;
import com.wfuhui.modules.api.annotation.LoginUser;
import com.wfuhui.modules.base.entity.UserEntity;
import com.wfuhui.modules.market.entity.ActivityEntity;
import com.wfuhui.modules.market.entity.ActivityJoinEntity;
import com.wfuhui.modules.market.service.ActivityJoinService;
import com.wfuhui.modules.market.service.ActivityService;

/**
 * 活动
 *
 *
 */
@RestController
@RequestMapping("/api/activity/")
public class ApiActivityController {

	@Autowired
	private ActivityService activityService;

	@Autowired
	private ActivityJoinService activityJoinService;

	@AuthIgnore
	@GetMapping("list")
	public R list(@RequestParam Map<String, Object> params){
		params.put("status", 1);
		Query query = new Query(params);
		List<ActivityEntity> activityList = activityService.queryList(query);
		Integer total = activityService.queryTotal(params);
		return R.ok().put("activityList", activityList).put("total", total);
	}

	@AuthIgnore
	@GetMapping("detail")
	public R detail(Integer id){
		ActivityEntity activity = activityService.queryObject(id);
		return R.ok().put("activity", activity);
	}

	@GetMapping("getOne")
	private R getOne(Long storeId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("storeId", storeId);
		ActivityEntity activity = activityService.queryOne(params);
		return R.ok().put("activity", activity);
	}

	@PostMapping("join")
	public R join(@LoginUser UserEntity user, @RequestBody ActivityJoinEntity activityJoin){
		ActivityJoinEntity aj = activityJoinService.query(activityJoin.getActivityId(), user.getId().intValue());
		if(aj != null) {
			return R.error("您已报名，请勿重复报名");
		}
		activityJoin.setCreateTime(new Date());
		activityJoin.setRealName(user.getRealName());
		activityJoin.setMobile(user.getMobile());
		activityJoin.setMemberId(user.getId().intValue());
		activityJoinService.save(activityJoin);
		return R.ok();
	}

	@GetMapping("start")
	public R start(@LoginUser UserEntity user, Integer id){
		ActivityJoinEntity aj = new ActivityJoinEntity();
		aj.setId(id);
		aj.setStatus(1);
		activityJoinService.update(aj);
		return R.ok();
	}

	@GetMapping("myJoin")
	public R myJoin(@LoginUser UserEntity user) {
		List<ActivityJoinEntity> activityJoinList = activityJoinService.queryMyjoin(user.getId().intValue());
		return R.ok().put("activityJoinList", activityJoinList);
	}
}