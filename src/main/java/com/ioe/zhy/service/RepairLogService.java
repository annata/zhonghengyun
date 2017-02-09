/**
 * 
 */
package com.ioe.zhy.service;

import java.util.Date;

/**
 * @author hq
 *
 */
public interface RepairLogService {
	public  int addOrderLog (String order_id,String operator_id,String before_status,String after_status,Long 
			operator_time,String remark,String sys_hash);

}
