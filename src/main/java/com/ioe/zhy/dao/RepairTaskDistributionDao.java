/**
 * 
 */
package com.ioe.zhy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	
	public List<RepairTaskDistribution> getPeoplesByTaskId(String task_id);
	
	public List<String> getDistributionIdByTaskId(String task_id);
	
	public int changeDistributionStatusByTaskId(@Param("task_id")String task_id,@Param("distribution_status")String distribution_status);
	
	public   List<RepairOrder>     getHistoryByElectricianId(@Param("userId")String userId,
	@Param("createTime")long createTime,@Param("completeTime")long completeTime,@Param("startNumber")Integer startNumber,@Param("PageCount")Integer PageCount);

	public int  getHistoryCountsByElectricianId(@Param("userId")String userId,
	@Param("createTime")long createTime,@Param("completeTime")long completeTime);
}
