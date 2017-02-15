/**
 * 
 */
package com.ioe.zhy.dao;

import com.ioe.zhy.entity.RepairOrderLog;

/**
 * @author hq
 *
 */
public interface RepairOrderLogDao {
	public int addOrderLog(RepairOrderLog repairOrderLog);
//	public int changeOrderLog(RepairOrderLog repairOrderLog);
	public String getOrderStatus(String order_id);

}
