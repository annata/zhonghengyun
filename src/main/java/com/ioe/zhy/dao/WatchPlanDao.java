/**
 * 
 */
package com.ioe.zhy.dao;

import org.apache.ibatis.annotations.Param;

import com.ioe.zhy.entity.WatchPlan;

/**
 * @author hq
 *
 */
public interface WatchPlanDao {
	public int addWatchPlan(WatchPlan watchPlan);
	public int updateWatchPlan(WatchPlan watchPlan);
	public int deleteWatchPlan(@Param("plan_id")String plan_id,@Param("sys_hash")String sys_hash);
	public int  beginWatch(@Param("start_real_time")long start_real_time,@Param("plan_id")String plan_id,@Param("sys_hash")String sys_hash);
	public int  completeWatch(@Param("end_real_time")long end_real_time,@Param("plan_id")String plan_id,@Param("sys_hash")String sys_hash);

}
