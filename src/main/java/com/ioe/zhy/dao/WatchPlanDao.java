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
	public int deleteWatchPlan(String plan_id);
	public int  beginWatch(@Param("start_real_time")long start_real_time,@Param("plan_id")String plan_id);
	public int  completeWatch(@Param("end_real_time")long end_real_time,@Param("plan_id")String plan_id);

}
