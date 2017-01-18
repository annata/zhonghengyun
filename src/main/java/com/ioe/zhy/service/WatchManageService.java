/**
 * 
 */
package com.ioe.zhy.service;

import com.ioe.zhy.entity.WatchPlan;
import com.ioe.zhy.util.DataResult;
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
	 * @param planId
	 * @return   
	 * @throws
	 */
	public  Result beginWatch(String planId);
	
	
	/**
	 * 交班
	 * @param planId
	 * @return   
	 * @throws
	 */
	public Result completeWatch(String planId);
	
}
