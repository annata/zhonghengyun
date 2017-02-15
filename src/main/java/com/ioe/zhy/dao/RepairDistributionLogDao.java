/**
 * 
 */
package com.ioe.zhy.dao;

import java.util.List;

import com.ioe.zhy.entity.RepairDistributionLog;

/**
 * @author hq
 *
 */
public interface RepairDistributionLogDao {
	public int addDistributionLogList(List<RepairDistributionLog> list);
	public int addDistributionLog(RepairDistributionLog repairDistributionLog);
	
//	public int changeDistributionLog(RepairDistributionLog repairDistributionLog);

}
