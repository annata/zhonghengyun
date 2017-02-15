/**
 * 
 */
package com.ioe.zhy.dao;

import java.util.List;
import java.util.Map;

import com.ioe.zhy.entity.RepairOrder;
import com.ioe.zhy.entity.RepairTaskDistribution;

/**
 * @author hq
 *
 */
public interface RepairTaskDistributionDao {
	public int addTaskDistributionList(List<RepairTaskDistribution> list);
	public List<RepairOrder> getTodoLists(String userId);
	public int changeDistributionById(RepairTaskDistribution repairTaskDistribution );
	public String getDistributionStatusById(String distribution_id);
	
	public int getOrderStatusById(String distribution_id);
	public int getOrderById(String distribution_id);
	
	public List<Map<String, String>> getPeoplesByTaskId(String task_id);
	

}
