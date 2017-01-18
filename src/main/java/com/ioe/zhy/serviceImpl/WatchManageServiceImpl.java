/**
 * 
 */
package com.ioe.zhy.serviceImpl;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ioe.common.util.Constants;
import com.ioe.common.util.ZRIGenerater;
import com.ioe.zhy.dao.WatchPlanDao;
import com.ioe.zhy.entity.WatchPlan;
import com.ioe.zhy.entity.WatchRecord;
import com.ioe.zhy.service.WatchManageService;
import com.ioe.zhy.util.DataResult;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.PageResult;
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
			watchPlan.setSys_hash("1");
			watchPlan.setSys_create_time(new Date());;
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
			watchPlan.setPlan_id(planId);
			watchPlan.setArea_id(areaId);
			watchPlan.setStart_time(startTime);
			watchPlan.setEnd_time(endTime);
			watchPlan.setStart_real_time(startRealTime);
			watchPlan.setEnd_real_time(endRealTime);
			watchPlan.setWatcher_id(watcherId);
			watchPlan.setLeader_id(leaderId);
			watchPlan.setType(type);
			watchPlan.setSys_hash("1");
			
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
		
			watchPlanDao.deleteWatchPlan(planId,"1");
			watchPlanDao.deleteWatchRecord(planId, "1");
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
			watchPlanDao.beginWatch(start_real_time, planId,"1");
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("beginWatch error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("beginWatch error");
		}
		return result;
	}



	@Override
	public Result completeWatch(String planId,String content) {
		Result result =new Result();
		
		try {
			long end_real_time=System.currentTimeMillis();
			watchPlanDao.completeWatch(end_real_time, planId,"1");
		   watchPlanDao.addWatchRecord(ZRIGenerater.generate(SERVICE_NAME), planId, "2", content, new Date());
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("completeWatch error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("completeWatch error");
		}
		return result;
	}


	
	@Override
	public ListResult<WatchPlan> getWatchPlan(String userId) {
		ListResult<WatchPlan>  listResult=new  ListResult<WatchPlan>();
		try {
			listResult.setDataList(watchPlanDao.getWatchPlan(userId, System.currentTimeMillis()));
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("getWatchPlan error");
			listResult.setCode(Constants.SERVICE_ERROR);
			listResult.setMessage("getWatchPlan error");
		}
		
		
		
		
		return listResult;
	}


	
	@Override
	public PageResult<WatchPlan> getHistoryWatchPlan(String userId, Integer pageIndex, Integer pageSize) {
		PageResult<WatchPlan> pageResult=new PageResult<>();
		try {
			int startNumber=(pageIndex-1)*pageSize;
			pageResult.setLength(pageSize);
			pageResult.setStart(pageIndex);
			pageResult.setDataList(watchPlanDao.getHistoryWatchPlan(userId, System.currentTimeMillis(), startNumber,pageSize));
			pageResult.setTotalCount(watchPlanDao.selectHistoryWatchPlanCountByUserId(userId, System.currentTimeMillis()));

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("getHistoryWatchPlan error");
			pageResult.setCode(Constants.SERVICE_ERROR);
			pageResult.setMessage("getHistoryWatchPlan error");
		}
		return pageResult;
	}



	@Override
	public DataResult<WatchRecord> getWatchRecordByPlanId(String planId) {
	   DataResult<WatchRecord> dataResult=new DataResult<>();
	   try {

		   dataResult.setData(watchPlanDao.getWatchRecordByPlanId(planId) );

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("watchManage error");
			dataResult.setCode(Constants.SERVICE_ERROR);
			dataResult.setMessage("watchManage error");
		}
		return dataResult;
	}
	
	

}
