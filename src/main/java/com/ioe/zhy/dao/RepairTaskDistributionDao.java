/**
 * 
 */
package com.ioe.zhy.dao;

import java.util.List;

import com.ioe.zhy.entity.RepairOrder;
import com.ioe.zhy.entity.RepairTaskDistribution;

/**
 * @author hq
 *
 */
public interface RepairTaskDistributionDao {
	public int addTaskDistributionList(List<RepairTaskDistribution> list);
	public List<RepairOrder> getTodoLists(String userId);

}
