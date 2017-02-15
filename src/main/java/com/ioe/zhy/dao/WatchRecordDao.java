/**
 * 
 */
package com.ioe.zhy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ioe.zhy.entity.WatchRecord;

/**
 * @author hq
 *
 */
public interface WatchRecordDao {
	public  int addWatchRecordList(List<WatchRecord> list);
	public int deleteWatchRecordByPlanId(String  plan_id);
	public List<String> getWatchersByPlanId(String plan_id);
	public WatchRecord getWatchRecordByPlanId(String plan_id);
	public int changeWatchLeaderById(@Param("plan_id")String plan_id,@Param("watcher_id")String watcher_id,   @Param("is_leader")boolean is_leader);
	public int deleteWatchRecordList(Map<String, Object> map);
	public int beginWatch(@Param("plan_id")String plan_id,@Param("watcher_id")String watcher_id, @Param("start_time")long start_time);
	public int completeWatch(@Param("plan_id")String plan_id,@Param("watcher_id")String watcher_id, @Param("end_time")long end_time,@Param("content")String content);
}
