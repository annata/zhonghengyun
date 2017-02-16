/**
 * 
 */
package com.ioe.zhy.dao;

import com.ioe.zhy.entity.RrepairTask;

/**
 * @author hq
 *
 */
public interface RrepairTaskDao {
	public int addTask(RrepairTask repairTask);
	public String getNewstaskIdByOrderId(String order_id); 
	public String getSenderByOrderId(String task_id);

}
