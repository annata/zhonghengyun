/**
 * 
 */
package com.ioe.zhy.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ioe.common.util.Constants;
import com.ioe.common.util.ZRIGenerater;
import com.ioe.zhy.dao.WatchPlanDao;
import com.ioe.zhy.dao.WatchRecordDao;
import com.ioe.zhy.entity.WatchPlan;
import com.ioe.zhy.entity.WatchRecord;
import com.ioe.zhy.service.WatchManageService;
import com.ioe.zhy.util.DataResult;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.PageResult;
import com.ioe.zhy.util.Result;

import javassist.convert.TransformReadField;

import org.aspectj.bridge.MessageWriter;
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
	
	private static final String Record_SERVICE_NAME ="zhy/t_WatchRecordService";
	
	@Resource
	private WatchPlanDao watchPlanDao;
	
	@Resource
	private WatchRecordDao watchRecordDao;
	
	
	@Override
	public Result addWatchPlan(String areaId, long startTime, long endTime, String watcher, String watcherId,
			boolean type) {
		Result result =new Result();
		try {
			String planId=ZRIGenerater.generate(SERVICE_NAME);
			int a=watcher.indexOf(",");
			String watchleader=watcher.substring(0, a);
			String watchers=watcher.substring(a+1, watcher.length());
			WatchPlan  watchPlan=new WatchPlan();
			watchPlan.setPlan_id(planId);
			watchPlan.setArea_id(areaId);
			watchPlan.setStart_time(startTime);
			watchPlan.setEnd_time(endTime);
			watchPlan.setSys_hash("2");
			watchPlan.setWatcher(watchers);
			watchPlan.setWatch_leader(watchleader);
			watchPlan.setType(type);
			watchPlanDao.addWatchPlan(watchPlan);
			
			
			int b=watcher.indexOf(",");
			String watchleaderId=watcherId.substring(0, b);
			String watchersId=watcherId.substring(b+1, watcher.length());
			List<WatchRecord> list=new ArrayList<>();
			WatchRecord leader=new WatchRecord();
			leader.setPlan_id(planId);
			leader.setIs_leader(true);
			leader.setWatcher_id(watchleaderId);
			leader.setContent("");
			leader.setRecord_id(ZRIGenerater.generate(Record_SERVICE_NAME));
			list.add(leader);
			
			String[]  waId=watchersId.split(",");
			for(int i=0;i<waId.length;i++){
				Thread.sleep(1);
				WatchRecord watchRecord=new WatchRecord();
				watchRecord.setPlan_id(planId);
				watchRecord.setIs_leader(false);
				watchRecord.setWatcher_id(waId[i]);
				watchRecord.setRecord_id(ZRIGenerater.generate(Record_SERVICE_NAME));
				watchRecord.setContent("");
				list.add(watchRecord);
			}
			watchRecordDao.addWatchRecordList(list);
			 result.setMessage("success");
		} catch (Exception e) {
		
			LOG.error("addWatchPlan error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("addWatchPlan error");
		}	
		return  result;

	}
	
	

	@Override
	public Result updateWatchPlan(String planId, String areaId, long startTime, long endTime, String watcher, String watcherId,
			boolean type) {
		Result result =new Result();
		try {
			
			int a=watcher.indexOf(",");
			String watchleader=watcher.substring(0, a);
			String watchers=watcher.substring(a+1, watcher.length());
			WatchPlan  watchPlan=new WatchPlan();
			watchPlan.setPlan_id(planId);
			watchPlan.setArea_id(areaId);
			watchPlan.setStart_time(startTime);
			watchPlan.setEnd_time(endTime);
			watchPlan.setSys_hash("2");
			watchPlan.setWatcher(watchers);
			watchPlan.setWatch_leader(watchleader);
			watchPlan.setType(type);						
			watchPlanDao.updateWatchPlan(watchPlan);
			
			int b=watcher.indexOf(",");
			String watchleaderId=watcherId.substring(0, b);
			String watchersId=watcherId.substring(b+1, watcher.length());
			
			List<String>  nowWatchersIdList=new ArrayList<>(); 
			for(String s:watchersId.split(",")){
				nowWatchersIdList.add(s);
			}
			
			List<String>   ageWatchersIdList=watchRecordDao.getWatchersByPlanId(planId); 
			WatchRecord leader=watchRecordDao.getWatchRecordByPlanId(planId);
			
			//如果以前的值班领导在现在的值班人员中,更改
			if(!nowWatchersIdList.isEmpty()){
				
				if(nowWatchersIdList.contains(leader.getWatcher_id())){
					watchRecordDao.changeWatchLeaderById(leader.getPlan_id(),leader.getWatcher_id(),false);
				}
				
			}
			
			//如果现在的值班领导在以前的值班人员中,更改
			if(!ageWatchersIdList.isEmpty()){
				if(ageWatchersIdList.contains(watchleaderId)){
					watchRecordDao.changeWatchLeaderById(planId, watchleaderId, true);
				}
			}
			
			nowWatchersIdList.add(watchleaderId);
			ageWatchersIdList.add(leader.getWatcher_id());
			
			List<String>  list=new ArrayList<>(nowWatchersIdList);
			List<WatchRecord> wrlist=new ArrayList<>();
			
		
			nowWatchersIdList.removeAll(ageWatchersIdList);
			if(!nowWatchersIdList.isEmpty()){
				for(String wId:nowWatchersIdList){
					WatchRecord watchRecord=new WatchRecord();
					Thread.sleep(1);
					watchRecord.setPlan_id(planId);
					watchRecord.setIs_leader(false);
					watchRecord.setWatcher_id(wId);
					watchRecord.setRecord_id(ZRIGenerater.generate(Record_SERVICE_NAME));
					watchRecord.setContent("");
					wrlist.add(watchRecord);
				}
				watchRecordDao.addWatchRecordList(wrlist);
			}
			
			ageWatchersIdList.removeAll(list);
			if(!ageWatchersIdList.isEmpty()){
			Map<String, Object> map=new HashMap<>();
			  map.put("plan_id", planId);
			   map.put("list", ageWatchersIdList);
			   watchRecordDao.deleteWatchRecordList(map);
			
			}
			result.setMessage("success");
		} catch (Exception e) {
		
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
			watchPlanDao.deleteWatchPlan(planId, "4");
			watchRecordDao.deleteWatchRecordByPlanId(planId);
			result.setMessage("success");
	} catch (Exception e) {
	
		LOG.error("deleteWatchPlan error");
		result.setCode(Constants.SERVICE_ERROR);
		result.setMessage("deleteWatchPlan error");
	}	
	return  result;
	}

	

	@Override
	public Result beginWatch(String planId, String userId) {
		Result result =new Result();
		
		try {
			watchRecordDao.beginWatch(planId, userId, System.currentTimeMillis());
			} catch (Exception e) {
		
			LOG.error("beginWatch error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("beginWatch error");
		}
		return result;
	}
	
	

	@Override
	public Result completeWatch(String planId,String userId,String content){
	Result result =new Result();
		
		try {
			watchRecordDao.completeWatch(planId, userId, System.currentTimeMillis(), content);
			} catch (Exception e) {
			
			LOG.error("completeWatch error");
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("completeWatch error");
		}
		return result;
	}

	
	@Override
	public PageResult<WatchPlan> getWatchPlan(String userId,boolean type,Integer  pageIndex,Integer pageSize) {
		PageResult<WatchPlan> pageResult=new PageResult<>();
		try {
			int startNumber=(pageIndex-1)*pageSize;
			pageResult.setLength(pageSize);
			pageResult.setStart(pageIndex);
			pageResult.setDataList(watchPlanDao.getWatchPlan(userId, type, System.currentTimeMillis(), startNumber, pageSize));
			pageResult.setTotalCount(watchPlanDao.getWatchPlanCountByUserId(userId, type, System.currentTimeMillis()));
			pageResult.setMessage("success");
		} catch (Exception e) {
		e.printStackTrace();
		LOG.error("getWatchPlan error");
		pageResult.setCode(Constants.SERVICE_ERROR);
		pageResult.setMessage("getWatchPlan error");
	}
	return pageResult;
		
	}
	
	

	@Override
	public PageResult<WatchPlan> getHistoryWatchPlan(String userId,boolean type,long startTime,   long endTime, Integer  pageIndex,Integer pageSize) {
		PageResult<WatchPlan> pageResult=new PageResult<>();
		try {
			int startNumber=(pageIndex-1)*pageSize;
			pageResult.setLength(pageSize);
			pageResult.setStart(pageIndex);
			pageResult.setDataList(watchPlanDao.getHistoryWatchPlan(userId, type, System.currentTimeMillis(), startTime, endTime, startNumber, pageSize));
			pageResult.setTotalCount(watchPlanDao.getHistoryWatchPlanCountByUserId(userId, type, System.currentTimeMillis(), startTime, endTime));
			pageResult.setMessage("success");
		} catch (Exception e) {
		e.printStackTrace();
		LOG.error("getHistoryWatchPlan error");
		pageResult.setCode(Constants.SERVICE_ERROR);
		pageResult.setMessage("getHistoryWatchPlan error");
	}
	return pageResult;
	}








	
	@Override
	public  DataResult<String> getWatchRecordByPlanId(String planId) {
		DataResult<String> dataResult=new DataResult<>();
		try {
			;
			dataResult.setData(watchRecordDao.getWatchRecordByPlanId(planId).getContent());
		dataResult.setMessage("success");
		} catch (Exception e) {
		e.printStackTrace();
		LOG.error("getWatchRecordByPlanId error");
		dataResult.setCode(Constants.SERVICE_ERROR);
		dataResult.setMessage("getWatchRecordByPlanId error");
	}
	return dataResult;
	}





	
	
	
	

}
