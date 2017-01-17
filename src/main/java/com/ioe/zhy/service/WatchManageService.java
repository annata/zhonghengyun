/**
 * 
 */
package com.ioe.zhy.service;


import com.ioe.zhy.util.DataResult;
import com.ioe.zhy.util.Result;

/**
 * @author hq
 *
 */
public interface WatchManageService {
	public  Result addWatchPlan(String area_id,long start_time,long end_time,long 
			start_real_time,long end_real_time,long watcher_id,long leader_id,boolean type);         

}
