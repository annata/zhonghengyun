/**
 * 
 */
package com.ioe.zhy.serviceImpl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ioe.common.util.ZRIGenerater;
import com.ioe.zhy.dao.RepairOrderLogDao;
import com.ioe.zhy.entity.RepairOrderLog;
import com.ioe.zhy.service.RepairLogService;

/**
 * @author hq
 *
 */
@Service("repairLogService")
@Transactional
public class RepairLogServiceImpl implements RepairLogService {
	
    private static final String SERVICE_NAME = "zhy/t_RepairLogService";
    @Resource
    RepairOrderLogDao repairOrderLogDao;


	@Override
	public int addOrderLog( String order_id, String operator_id, String before_status,
			String after_status, Long operator_time, String remark, String sys_hash) {
		RepairOrderLog repairOrderLog=new RepairOrderLog();
		repairOrderLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairLogService"));
		repairOrderLog.setOrder_id(order_id);
		repairOrderLog.setOperator_id(operator_id);
		repairOrderLog.setBefore_status(before_status);
		repairOrderLog.setAfter_status(after_status);
		repairOrderLog.setOperator_time(operator_time);
		repairOrderLog.setRemark(remark);
		repairOrderLog.setSys_hash(sys_hash);

		
		return repairOrderLogDao.addOrderLog(repairOrderLog);
	}

}
