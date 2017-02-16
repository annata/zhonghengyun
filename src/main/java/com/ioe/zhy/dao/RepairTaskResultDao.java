/**
 * 
 */
package com.ioe.zhy.dao;

import com.ioe.zhy.entity.RepairTaskResult;

/**
 * @author hq
 *
 */
public interface RepairTaskResultDao {
	public int addTaskResult(RepairTaskResult repairTaskResult);
	
	public int getTaskIdIsExist(String taskId);

}
