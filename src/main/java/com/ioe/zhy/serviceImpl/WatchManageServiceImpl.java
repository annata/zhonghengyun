/**
 * 
 */
package com.ioe.zhy.serviceImpl;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ioe.zhy.dao.WatchPlanDao;
import com.ioe.zhy.entity.WatchPlan;
import com.ioe.zhy.service.WatchManageService;
import com.ioe.zhy.util.DataResult;
import com.ioe.zhy.util.Result;

import org.slf4j.Logger;

/**
 * @author hq
 *
 */
@Service("watchManageService")
@Transactional
public class WatchManageServiceImpl implements WatchManageService{

	private final Logger LOG = LoggerFactory
			.getLogger(WatchManageService.class);
	
	
	@Resource
	private WatchPlanDao watchPlanDao;

	public Result addWatchPlan(String area_id, long start_time, long end_time, long start_real_time, long end_real_time,
			long watcher_id, long leader_id, boolean type) {
		Result result =new Result();
		
		try {
			WatchPlan  watchPlan=new WatchPlan();
			watchPlan.setArea_id(area_id);
			watchPlan.setStart_time(start_time);
			watchPlan.setEnd_time(end_time);
			watchPlan.setStart_real_time(start_real_time);
			watchPlan.setEnd_real_time(end_real_time);
			watchPlan.setWatcher_id(watcher_id);
			watchPlan.setLeader_id(leader_id);
			watchPlan.setType(type);
			watchPlanDao.addWatchPlan(watchPlan);
		} catch (Exception e) {
			LOG.error("addWatchPlan errer");
			result.setMessage("addWatchPlan errer");
		}	
		return  result;
	}

}
