/**
 * 
 */
package com.ioe.zhy.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.ioe.zhy.entity.RepairOrder;

/**
 * @author hq
 *
 */

public interface RepairOrderDao {
	public int addOrder(RepairOrder repairOrder);
	public String getTodayLastOrder(@Param("zeroTime")Date zeroTime,@Param("twelve")Date twelve);
	public int changeOrder(RepairOrder repairOrder);
}
