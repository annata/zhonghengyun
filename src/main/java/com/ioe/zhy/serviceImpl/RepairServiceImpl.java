/**
 * 
 */
package com.ioe.zhy.serviceImpl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ioe.common.util.Constants;
import com.ioe.common.util.ZRIGenerater;
import com.ioe.customer.client.entity.Employee;
import com.ioe.customer.client.service.EmployeeService;
import com.ioe.zhy.dao.RepairDistributionLogDao;
import com.ioe.zhy.dao.RepairOrderDao;
import com.ioe.zhy.dao.RepairOrderLogDao;
import com.ioe.zhy.dao.RepairTaskDistributionDao;
import com.ioe.zhy.dao.RrepairTaskDao;
import com.ioe.zhy.entity.RepairDistributionLog;
import com.ioe.zhy.entity.RepairOrder;
import com.ioe.zhy.entity.RepairOrderLog;
import com.ioe.zhy.entity.RepairTaskDistribution;
import com.ioe.zhy.entity.RrepairTask;
import com.ioe.zhy.service.RepairLogService;
import com.ioe.zhy.service.RepairService;
import com.ioe.zhy.util.DataResult;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.Result;

/**
 * @author hq
 *
 */

@Service("repairService")
@Transactional
public class RepairServiceImpl implements RepairService {
	private static final String SERVICE_NAME = "zhy/t_RepairService";

	private final Logger LOG = LoggerFactory.getLogger(RepairService.class);

	@Resource
	private RepairOrderDao repairOrderDao;

	@Resource
	private RepairOrderLogDao repairOrderLogDao;
	
	@Resource
	private RrepairTaskDao repairTaskDao;
	
	  @Resource
	   private RepairTaskDistributionDao repairTaskDistributionDao;	   
	   
	   @Resource
	   private RepairDistributionLogDao repairDistributionLogDao;
	   
//	   @Resource
//	   private EmployeeService employeeService;

	@Override
	public ListResult<RepairOrder> getTodoListByUserId(String companyId, String userId,String role) {
		ListResult<RepairOrder> listResult = new ListResult<>();
		try {
		if("运维电工".equals(role)){
			listResult.setDataList(repairTaskDistributionDao.getTodoLists(userId));
		}else if("用电主管".equals(role)){
			listResult.setDataList( repairOrderDao.getTodoOrder(companyId)	);
		}
			listResult.setMessage("success");
		} catch (Exception e) {
			e.printStackTrace();
			listResult.setCode(Constants.SERVICE_ERROR);
			listResult.setMessage("getTodoListByUserId error");
	}
		return listResult;
	}

	@Override
	public Result addOrder(String operator, String powerClientId, String powerClientManager, String managePhone,
			String faultSource, String faultDevice, String faultDesc, String faultLevel, String areaElectrician) {
		Result result = new Result();
		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			long current = System.currentTimeMillis();// 当前时间毫秒数
			long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();// 今天零点零分零秒的毫秒数
			long twelve = zero + 24 * 60 * 60 * 1000 - 1;// 今天23点59分59秒的毫秒数
			String order_no = repairOrderDao.getTodayLastOrder(new Date(zero), new Date(twelve));
			NumberFormat nf = NumberFormat.getInstance();
			// 设置是否使用分组
			nf.setGroupingUsed(false);
			// 设置最大整数位数
			nf.setMaximumIntegerDigits(5);
			// 设置最小整数位数
			nf.setMinimumIntegerDigits(5);
			if (order_no == null) {
				order_no = simpleDateFormat.format(new Date()) + "00001";
			} else {
				int no = Integer.valueOf(order_no.substring(order_no.length() - 5, order_no.length())) + 1;
				order_no = order_no.substring(0, order_no.length() - 5) + nf.format(no);
			}
			String OrderId=ZRIGenerater.generate(SERVICE_NAME);
			RepairOrder repairOrder = new RepairOrder();
			repairOrder.setOrder_id(OrderId);
			repairOrder.setPowerClient_id(powerClientId);
			repairOrder.setOrder_no(order_no);

			repairOrder.setPowerClient_manager(powerClientManager);
			repairOrder.setManager_phone(managePhone);
			repairOrder.setFault_source(faultSource);
			repairOrder.setFault_device(faultDevice);
			repairOrder.setFault_desc(faultDesc);
			repairOrder.setFault_level(faultLevel);
			repairOrder.setArea_electrician(areaElectrician);
			repairOrder.setOrder_status("待派发");
			repairOrder.setSys_hash("12");
			repairOrderDao.addOrder(repairOrder);

			RepairOrderLog repairOrderLog = new RepairOrderLog();
			repairOrderLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairLogService"));
			repairOrderLog.setOrder_id(OrderId);
			repairOrderLog.setOperator_id(operator);
			repairOrderLog.setBefore_status("");
			repairOrderLog.setAfter_status("待派发");
			repairOrderLog.setOperator_time(System.currentTimeMillis());
			repairOrderLog.setRemark(null);
			repairOrderLog.setSys_hash("3");
			repairOrderLogDao.addOrderLog(repairOrderLog);
			result.setMessage(OrderId);
		} catch (Exception e) {

			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("addOrder error");

		}
		return result;
	}

	@Override
	public Result ignoreOrder(String orderId, String operator, String remark) {
		Result result = new Result();
		try {
			RepairOrder repairOrder = new RepairOrder();
			repairOrder.setOrder_id(orderId);
			repairOrder.setOrder_status("忽略");
			repairOrder.setSys_hash("12");
			repairOrderDao.changeOrder(repairOrder);
			
			RepairOrderLog repairOrderLog = new RepairOrderLog();
			repairOrderLog.setOrder_id(orderId);
			repairOrderLog.setOperator_time(System.currentTimeMillis());
			repairOrderLog.setBefore_status(repairOrderLogDao.getOrderStatus(orderId));
			repairOrderLog.setAfter_status("忽略");
			repairOrderLog.setOperator_id(operator);
			repairOrderLog.setRemark(remark);
			repairOrderLog.setSys_hash("3");
			repairOrderLogDao.changeOrderLog(repairOrderLog);
			result.setMessage("success");
		} catch (Exception e) {

			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("ignoreOrder error");
		
		}
		return result;

	}


	@Override
	public Result sendOrder(String orderId, String operator, Boolean needPowerOff, String powerOffTime,
			String primaryElectrician, String cooperateElectrician) {
		Result result = new Result();
		try {
			long time=System.currentTimeMillis();
			String task_id=ZRIGenerater.generate("zhy/t_RrepairTask");
			 RrepairTask  repairTask=new  RrepairTask();
			 repairTask.setTask_id(task_id);
			 repairTask.setOrder_id(orderId);
			 repairTask.setSender(operator);
			 repairTask.setSend_time(time);
			 repairTask.setNeed_powerOff(needPowerOff);
			 repairTask.setPowerOff_time(powerOffTime);
			 repairTask.setSys_hash("1");
			 repairTaskDao.addTask(repairTask);
			 
			 List<RepairTaskDistribution> taskDistributionList=new ArrayList<>();		
			 RepairTaskDistribution taskDistribution=new RepairTaskDistribution();
			 String   taskDistributionId    =ZRIGenerater.generate("zhy/t_RepairTaskDistributionService");
			 taskDistribution.setDistribution_id(taskDistributionId);
			 taskDistribution.setDistribution_status("待接单");
			 taskDistribution.setElectrician_id(primaryElectrician);
			 taskDistribution.setTask_id(task_id);
			 taskDistribution.setIs_primary(true);
			 taskDistribution.setOrder_id(orderId);
			 taskDistributionList.add(taskDistribution);
			 
			 List<RepairDistributionLog> repairDistributionLogList=new ArrayList<>();
			 RepairDistributionLog repairDistributionLog=new RepairDistributionLog();
			 repairDistributionLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLogService"));
			 repairDistributionLog.setDistribution_id(taskDistributionId);
			 repairDistributionLog.setOperator_id(operator);
			 repairDistributionLog.setOperator_time(time);
			 repairDistributionLog.setSys_hash("1");	
			 repairDistributionLog.setBefore_status("待派发");
			 repairDistributionLog.setAfter_status("待接单");
			 repairDistributionLogList.add(repairDistributionLog);
			 
			 if(cooperateElectrician!=null&&!("").equals(cooperateElectrician)){
				 String[] coop= cooperateElectrician.split(",");
				 for(int i=0;i<coop.length;i++){
					 Thread.sleep(1);
					 RepairTaskDistribution task=new RepairTaskDistribution();
					 String   taskId    =ZRIGenerater.generate("zhy/t_RepairTaskDistributionService");
					 task.setDistribution_id(taskId);
					 task.setDistribution_status("待接单");
					 task.setElectrician_id(coop[i]);
					 task.setTask_id(task_id);
					 task.setIs_primary(false);
					 task.setOrder_id(orderId);
					 taskDistributionList.add(task);
					 
					 RepairDistributionLog Log=new RepairDistributionLog();
					 Log.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLogService"));
					 Log.setDistribution_id(taskId);
					 Log.setOperator_id(operator);
					 Log.setOperator_time(time);
					 Log.setSys_hash("1");	
					 Log.setBefore_status("待派发");
					 Log.setAfter_status("待接单");
					 repairDistributionLogList.add(Log);
				 }
			 }
			 
			 repairTaskDistributionDao.addTaskDistributionList(taskDistributionList);
			 repairDistributionLogDao.addDistributionLog(repairDistributionLogList);
			 RepairOrder repairOrder=new RepairOrder();
			 repairOrder.setOrder_id(orderId);
			 repairOrder.setOrder_status("待接单");
			 repairOrder.setSys_hash("1");
			 repairOrderDao.changeOrder(repairOrder);
			 RepairOrderLog repairOrderLog=new RepairOrderLog();
			 repairOrderLog.setOrder_id(orderId);
			 repairOrderLog.setOperator_id(operator);
			 repairOrderLog.setOperator_time(time);
			 repairDistributionLog.setSys_hash("1");
			 repairOrderLog.setBefore_status("待派发");
			 repairOrderLog.setAfter_status("待接单");
			 repairOrderLogDao.changeOrderLog(repairOrderLog);
			 result.setMessage("success");
		} catch (Exception e) {
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("sendOrder error");
		}
		return result;
		
	}

}
