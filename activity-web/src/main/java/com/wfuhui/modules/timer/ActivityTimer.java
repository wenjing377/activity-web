package com.wfuhui.modules.timer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wfuhui.modules.market.entity.ActivityEntity;
import com.wfuhui.modules.market.service.ActivityService;


@Component
@Configuration
@EnableScheduling
public class ActivityTimer {
	
	@Autowired
	private ActivityService activityService;

	/**
	 * 10秒执行一次
	 */
	@Scheduled(cron = "0/10 * * * * *")
	public void saveDistributor() {
		System.out.println("--活动定时器--");
		List<ActivityEntity> activityList = activityService.queryList(null);
		for (ActivityEntity activity : activityList) {
			
		}
		
	}
}
