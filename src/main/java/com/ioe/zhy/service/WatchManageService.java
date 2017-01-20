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
	 * @param startRealTime  实际开始时间
	 * @param endRealTime    实际结束时间
	 * @param watcherId     值班人id
	 * @param leaderId     值班领导id
	 * @param type      计划类型
	 * @return    操作结果，成功时包含监控项唯一标识RI
	 */
	public Result addWatchPlan(String areaId, long startTime, long endTime, long startRealTime, long endRealTime,
			long watcherId, long leaderId, boolean type);

	
	
	
	/**
	 * 修改值班计划
	 * @param planId  计划id
	 * @param areaId  区域id
	 * @param startTime  计划开始时间
	 * @param endTime    计划结束时间
	 * @param startRealTime  实际开始时间
	 * @param endRealTime    实际结束时间
	 * @param watcherId     值班人id
	 * @param leaderId     值班领导id
	 * @param type      计划类型
	 * @return    操作结果，成功时包含监控项唯一标识RI
	 */
	public Result updateWatchPlan(String planId, String areaId, long startTime, long endTime, long startRealTime, long endRealTime,
			long watcherId, long leaderId, boolean type);

	/**
	 * 删除值班计划
	 * @param planId  计划id
	 * @return   操作结果，成功时包含监控项唯一标识RI 
	 */
	public Result deleteWatchPlan(String planId);
	
	/**
	 * 接班
	 * @param planId 计划id
	 * @return    操作结果，成功时包含监控项唯一标识RI
	 */
	public  Result beginWatch(String planId);
	
	
	/**
	 * 交班
	 * @param planId 计划id
	 * @return    操作结果，成功时包含监控项唯一标识RI
	 */
	public Result completeWatch(String planId,String content);
	
	/**
	 * 查询值班计划
	 * @param userId   用户id
	 * @return   操作结果，成功时包含监控项唯一标识RI
	 */
	public ListResult<WatchPlan> getWatchPlan(String userId);
	
	
	
	/**
	 * 查询历史值班
	 * @param userId 用户id
	 * @param startTime 开始时间
	 * @param endTime  结束时间
	 * @param pageIndex  显示第几页 
	 * @param pageSize  每页大小
	 * @return   
	 */
	public PageResult<WatchPlan> getHistoryWatchPlan(String userId,long startTime,long endTime, Integer  pageIndex,Integer pageSize);
	
	/**
	 * 查询值班记录
	 * @param planId  计划id
	 * @return   
	 */
	public DataResult<WatchRecord> getWatchRecordByPlanId(String planId);
}
