/**
 * 
 */
package com.ioe.zhy.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ioe.zhy.entity.WatchPlan;
import com.ioe.zhy.entity.WatchRecord;

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
	public int deleteWatchRecord(@Param("plan_id")String plan_id,@Param("sys_hash")String sys_hash);
	public int addWatchRecord(@Param("record_id")String record_id,@Param("plan_id")String plan_id,@Param("sys_hash")String sys_hash,@Param("content")String content,@Param("sys_create_time")Date sys_create_time);
	public List<WatchPlan> getWatchPlan(@Param("watcher_id")String watcher_id,@Param("start_time")long start_time);
	public List<WatchPlan> getHistoryWatchPlan(@Param("watcher_id")String watcher_id,@Param("start_time")long start_time,@Param("startNumber")Integer startNumber,@Param("PageCount")Integer PageCount);
	public int selectHistoryWatchPlanCountByUserId(@Param("watcher_id")String watcher_id,@Param("start_time")long start_time);
	public WatchRecord  getWatchRecordByPlanId(String plan_id);
}
