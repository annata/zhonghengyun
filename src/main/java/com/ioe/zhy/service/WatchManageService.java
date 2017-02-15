/**
 * 
 */
package com.ioe.zhy.service;

import com.ioe.zhy.entity.WatchPlan;
import com.ioe.zhy.entity.WatchRecord;
import com.ioe.zhy.util.DataResult;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.PageResult;
import com.ioe.zhy.util.Result;

/**
 * @author hq
 *
 */
public interface WatchManageService {


	
	
	
	/**
	 *  新增值班计划
	 * 
	 * @param areaId  区域id
	 * @param startTime  计划开始时间
	 * @param endTime    计划结束时间
	 * @param watcher  值班人名字列表
	 * @param watcherId    值班人id列表
	 * @param type      计划类型
	 * @return    操作结果，成功时包含监控项唯一标识RI
	 */
	public Result addWatchPlan(String areaId, long startTime, long endTime,String watcher,String watcherId, boolean type);

	
	
	
	/**
	 * 修改值班计划
	 * @param planId 值班id
	 * @param areaId  区域id
	 * @param startTime  计划开始时间
	 * @param endTime    计划结束时间
	 * @param watcher  值班人名字列表
	 * @param watcherId    值班人id列表
	 * @param type      计划类型
	 * @return    操作结果，成功时包含监控项唯一标识RI
	 */
	public Result updateWatchPlan(String planId, String areaId, long startTime, long endTime,String watcher,String watcherId, boolean type);

	/**
	 * 删除值班计划
	 * @param planId  计划id
	 * @return   操作结果，成功时包含监控项唯一标识RI 
	 */
	public Result deleteWatchPlan(String planId);
	
	
	
	/**
	 * 接班
	 * @Title: beginWatch 
	 * @param planId  计划id
	 * @param userId  用户的id
	 * @return   
	 * @throws
	 */
	public  Result beginWatch(String planId,String userId);
	
	
	/**
	 * 交班
	 * @param planId 计划id
	 * @param userId  用户的id
	 * @param content 值班记录
	 * @return    操作结果，成功时包含监控项唯一标识RI
	 */
	public Result completeWatch(String planId,String userId,String content);
	
	
	
	/**
	 * 查询值班计划
	 * @Title: getWatchPlan 
	 * @param userId  用户id
	 * @param type  计划类型
	 * @param pageIndex  显示第几页 
	 * @param pageSize   每页大小
	 * @return   
	 * @throws
	 */
	public PageResult<WatchPlan> getWatchPlan(String userId,boolean type,Integer  pageIndex,Integer pageSize);
	
	
	

	
	/**
	 * 查询历史值班
	 * @Title: getHistoryWatchPlan 
	 * @param userId  用户id
	 * @param type  计划类型
	 * @param startTime   开始时间结束时间
	 * @param endTime   结束时间
	 * @param pageIndex   显示第几页 
	 * @param pageSize  每页大小
	 * @return   
	 * @throws
	 */
	public PageResult<WatchPlan> getHistoryWatchPlan(String userId,boolean type,long startTime,   long endTime, Integer  pageIndex,Integer pageSize);
	
	/**
	 * 查询值班记录
	 * @param planId  计划id
	 * @return   
	 */
	public DataResult<String> getWatchRecordByPlanId(String planId);
}
