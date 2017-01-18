/**
 * 
 */
package com.ioe.zhy.serviceImpl;

import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.ioe.common.util.Constants;
import com.ioe.common.util.ZRIGenerater;
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
	

	
	private static final String SERVICE_NAME = "zhy/t_WatchManageService";
	
	@Resource
	private WatchPlanDao watchPlanDao;
	
	@Override
	public Result addWatchPlan(String areaId, long startTime, long endTime, long startRealTime, long endRealTime,
			long watcherId, long leaderId, boolean type) {
		Result result =new Result();
		
		try {
			WatchPlan  watchPlan=new WatchPlan();
			watchPlan.setPlan_id(ZRIGenerater.generate(SERVICE_NAME));
			watchPlan.setArea_id(areaId);
			watchPlan.setStart_time(startTime);
			watchPlan.setEnd_time(endTime);
			watchPlan.setStart_real_time(startRealTime);
			watchPlan.setEnd_real_time(endRealTime);
			watchPlan.setWatcher_id(watcherId);
			watchPlan.setLeader_id(leaderId);
			watchPlan.setType(type);
			watchPlanDao.addWatchPlan(watchPlan);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("addWatchPlan error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("addWatchPlan error");
		}	
		return  result;
	}

	
	@Override
	public Result updateWatchPlan(String planId, String areaId, long startTime, long endTime, long startRealTime, long endRealTime,
			long watcherId, long leaderId, boolean type) {
		Result result =new Result();
		try {
			WatchPlan  watchPlan=new WatchPlan();
			watchPlan.setArea_id(areaId);
			watchPlan.setStart_time(startTime);
			watchPlan.setEnd_time(endTime);
			watchPlan.setStart_real_time(startRealTime);
			watchPlan.setEnd_real_time(endRealTime);
			watchPlan.setWatcher_id(watcherId);
			watchPlan.setLeader_id(leaderId);
			watchPlan.setType(type);
			watchPlanDao.updateWatchPlan(watchPlan);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("updateWatchPlan error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("updateWatchPlan error");
		}	
		return  result;
	}


	@Override
	public Result deleteWatchPlan(String planId) {
		Result result =new Result();
		try {
			watchPlanDao.deleteWatchPlan(planId);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("deleteWatchPlan error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("deleteWatchPlan error");
		}
		return result;
	}



	@Override
	public Result beginWatch(String planId) {
		Result result =new Result();
		
		try {
			long start_real_time=System.currentTimeMillis();
			watchPlanDao.beginWatch(start_real_time, planId);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("beginWatch error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("beginWatch error");
		}
		return result;
	}



	@Override
	public Result completeWatch(String planId) {
		Result result =new Result();
		try {
			long end_real_time=System.currentTimeMillis();
			watchPlanDao.completeWatch(end_real_time, planId);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("completeWatch error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("completeWatch error");
		}
		return result;
	}
	
	

}
