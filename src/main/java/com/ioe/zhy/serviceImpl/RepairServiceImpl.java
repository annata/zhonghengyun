/**
 * 
 */
package com.ioe.zhy.serviceImpl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.aspectj.bridge.MessageWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ioe.client.service.NoticePushService;
import com.ioe.common.util.Constants;
import com.ioe.common.util.ZRIGenerater;
import com.ioe.customer.client.entity.Employee;
import com.ioe.customer.client.service.EmployeeService;
import com.ioe.zhy.dao.RepairDistributionLogDao;
import com.ioe.zhy.dao.RepairOrderDao;
import com.ioe.zhy.dao.RepairOrderLogDao;
import com.ioe.zhy.dao.RepairTaskDistributionDao;
import com.ioe.zhy.dao.RepairTaskResultDao;
import com.ioe.zhy.dao.RrepairTaskDao;
import com.ioe.zhy.entity.Electrician;
import com.ioe.zhy.entity.RepairDistributionLog;
import com.ioe.zhy.entity.RepairOrder;
import com.ioe.zhy.entity.RepairOrderLog;
import com.ioe.zhy.entity.RepairTaskDistribution;
import com.ioe.zhy.entity.RepairTaskResult;
import com.ioe.zhy.entity.RrepairTask;
import com.ioe.zhy.service.RepairLogService;
import com.ioe.zhy.service.RepairService;
import com.ioe.zhy.util.DataResult;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.PageResult;
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
	
	
	private static final String electricianRole="用电电工";
	
	private static final String governorRole="主管";

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
	
	@Resource
	private RepairTaskResultDao repairTaskResultDao;

//	 @Resource
//	 private EmployeeService employeeService;

	// @Resource
	// private NoticePushService noticePushService;

	@Override
	public ListResult<RepairOrder> getTodoListByUserId(String companyId, String userId, String role) {
		ListResult<RepairOrder> listResult = new ListResult<>();
		try {
			if (electricianRole.equals(role)) {
				listResult.setDataList(repairTaskDistributionDao.getTodoLists(userId));
			} else if (governorRole.equals(role)) {
				listResult.setDataList(repairOrderDao.getTodoOrder(companyId));
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
	public PageResult<RepairOrder> getHistoryOrder(String userId, String role, String powerClientId, long startTime,
			long endTime, int pageIndex, int pageSize) {
		PageResult<RepairOrder> pageResult=new PageResult<RepairOrder>();
		try {
			if (electricianRole.equals(role)) {
				
			} else if (governorRole.equals(role)) {
				
			}
			pageResult.setMessage("success");
		} catch (Exception e) {
			e.printStackTrace();
			pageResult.setCode(Constants.SERVICE_ERROR);
			pageResult.setMessage("getTodoListByUserId error");
		}
		return pageResult;
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
			String OrderId = ZRIGenerater.generate(SERVICE_NAME);
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
			e.printStackTrace();
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

			RepairOrderLog repairOrderLog = new RepairOrderLog();
			repairOrderLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairLogService"));
			repairOrderLog.setOrder_id(orderId);
			repairOrderLog.setOperator_time(System.currentTimeMillis());
			repairOrderLog.setBefore_status(repairOrderLogDao.getOrderStatus(orderId));
			repairOrderLog.setAfter_status("忽略");
			repairOrderLog.setOperator_id(operator);
			repairOrderLog.setRemark(remark);
			repairOrderLog.setSys_hash("3");
			repairOrderLogDao.addOrderLog((repairOrderLog));
			repairOrderDao.changeOrder(repairOrder);
			result.setMessage("success");
		} catch (Exception e) {
			e.printStackTrace();
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
			String orderStatus = repairOrderDao.getOrderStatusById(orderId);
			long time = System.currentTimeMillis();
			String task_id = ZRIGenerater.generate("zhy/t_RrepairTask");
			RrepairTask repairTask = new RrepairTask();
			repairTask.setTask_id(task_id);
			repairTask.setOrder_id(orderId);
			repairTask.setSender(operator);
			repairTask.setSend_time(time);
			repairTask.setNeed_powerOff(needPowerOff);
			repairTask.setPowerOff_time(powerOffTime);
			repairTask.setSys_hash("1");
			repairTaskDao.addTask(repairTask);

			List<RepairTaskDistribution> taskDistributionList = new ArrayList<>();
			RepairTaskDistribution taskDistribution = new RepairTaskDistribution();
			String taskDistributionId = ZRIGenerater.generate("zhy/t_RepairTaskDistributionService");
			taskDistribution.setDistribution_id(taskDistributionId);
			taskDistribution.setDistribution_status("待接单");
			taskDistribution.setElectrician_id(primaryElectrician);
			taskDistribution.setTask_id(task_id);
			taskDistribution.setIs_primary(true);
			taskDistribution.setOrder_id(orderId);
			taskDistributionList.add(taskDistribution);

			List<RepairDistributionLog> repairDistributionLogList = new ArrayList<>();
			RepairDistributionLog repairDistributionLog = new RepairDistributionLog();
			repairDistributionLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLogService"));
			repairDistributionLog.setDistribution_id(taskDistributionId);
			repairDistributionLog.setOperator_id(operator);
			repairDistributionLog.setOperator_time(time);
			repairDistributionLog.setSys_hash("1");
			repairDistributionLog.setBefore_status("");
			repairDistributionLog.setAfter_status("待接单");
			repairDistributionLogList.add(repairDistributionLog);

			if (cooperateElectrician != null && !("").equals(cooperateElectrician)) {
				String[] coop = cooperateElectrician.split(",");
				for (int i = 0; i < coop.length; i++) {
					Thread.sleep(1);
					RepairTaskDistribution task = new RepairTaskDistribution();
					String taskId = ZRIGenerater.generate("zhy/t_RepairTaskDistributionService");
					task.setDistribution_id(taskId);
					task.setDistribution_status("待接单");
					task.setElectrician_id(coop[i]);
					task.setTask_id(task_id);
					task.setIs_primary(false);
					task.setOrder_id(orderId);
					taskDistributionList.add(task);

					RepairDistributionLog Log = new RepairDistributionLog();
					Log.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLogService"));
					Log.setDistribution_id(taskId);
					Log.setOperator_id(operator);
					Log.setOperator_time(time);
					Log.setSys_hash("1");
					Log.setBefore_status("");
					Log.setAfter_status("待接单");
					repairDistributionLogList.add(Log);
				}
			}

			repairTaskDistributionDao.addTaskDistributionList(taskDistributionList);
			repairDistributionLogDao.addDistributionLogList(repairDistributionLogList);
			RepairOrder repairOrder = new RepairOrder();
			repairOrder.setOrder_id(orderId);
			repairOrder.setOrder_status("待接单");
			repairOrder.setSys_hash("1");
			repairOrderDao.changeOrder(repairOrder);
			RepairOrderLog repairOrderLog = new RepairOrderLog();
			repairOrderLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairLogService"));
			repairOrderLog.setOrder_id(orderId);
			repairOrderLog.setOperator_id(operator);
			repairOrderLog.setOperator_time(time);
			repairDistributionLog.setSys_hash("1");
			repairOrderLog.setBefore_status(orderStatus);
			repairOrderLog.setAfter_status("待接单");
			repairOrderLogDao.addOrderLog(repairOrderLog);
			result.setMessage("success");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("sendOrder error");
		}
		return result;

	}

	@Override
	public Result receiveOrder(String userId, String distributionId, String orderId) {
		Result result = new Result();
		try {
			long time = System.currentTimeMillis();
			String repairDistributionLogStatus = repairTaskDistributionDao.getDistributionStatusById(distributionId);
			RepairTaskDistribution distribution = new RepairTaskDistribution();
			distribution.setDistribution_id(distributionId);
			distribution.setDistribution_status("待签到");
			repairTaskDistributionDao.changeDistributionById(distribution);

			RepairDistributionLog taskLog = new RepairDistributionLog();
			taskLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLogService"));
			taskLog.setDistribution_id(distributionId);
			taskLog.setBefore_status(repairDistributionLogStatus);
			taskLog.setAfter_status("待签到");
			taskLog.setOperator_time(time);
			taskLog.setOperator_id(userId);
			taskLog.setSys_hash("2");
			repairDistributionLogDao.addDistributionLog(taskLog);

			String orderStatus = repairOrderDao.getOrderStatusById(orderId);
			if (!"待签到".equals(orderStatus)) {
				RepairOrder order = new RepairOrder();

				order.setOrder_id(orderId);
				order.setOrder_status("待签到");
				order.setSys_hash("2");
				repairOrderDao.changeOrder(order);

				RepairOrderLog orderLog = new RepairOrderLog();
				orderLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairLogService"));
				orderLog.setOrder_id(orderId);
				orderLog.setOperator_id(userId);
				orderLog.setOperator_time(time);
				orderLog.setBefore_status(orderStatus);
				orderLog.setAfter_status("待签到");
				orderLog.setSys_hash("2");
				repairOrderLogDao.addOrderLog(orderLog);
			}
			result.setMessage("success");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("receiveOrder error");
		}

		return result;
	}

	@Override
	public Result refuseOrder(String userId, String distributionId, String orderId, String remark) {
		Result result = new Result();
		try {
			long time = System.currentTimeMillis();
			RepairTaskDistribution distribution = new RepairTaskDistribution();
			String distributionStatus = repairTaskDistributionDao.getDistributionStatusById(distributionId);
			distribution.setDistribution_id(distributionId);
			distribution.setDistribution_status("已回退");
			repairTaskDistributionDao.changeDistributionById(distribution);

			RepairDistributionLog taskLog = new RepairDistributionLog();
			taskLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLogService"));
			taskLog.setDistribution_id(distributionId);
			taskLog.setBefore_status(distributionStatus);
			taskLog.setAfter_status("已回退");
			taskLog.setOperator_time(time);
			taskLog.setOperator_id(userId);
			taskLog.setSys_hash("2");
			taskLog.setRemark(remark);
			repairDistributionLogDao.addDistributionLog(taskLog);

			RepairOrderLog orderLog = new RepairOrderLog();
			orderLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairLogService"));
			orderLog.setOrder_id(orderId);
			orderLog.setOperator_id(userId);
			orderLog.setOperator_time(time);
			orderLog.setBefore_status(repairOrderDao.getOrderStatusById(orderId));
			orderLog.setAfter_status("已回退");
			orderLog.setSys_hash("2");
			orderLog.setRemark(remark);
			repairOrderLogDao.addOrderLog(orderLog);
			// noticePushService.pushNotice(arg0, arg1, arg2, arg3)
			result.setMessage("success");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("refuseOrder error");
		}

		return result;
	}

	@Override
	public Result updateOrder(String orderId, String faultDevice, String faultDesc, String faultLevel) {
		Result result = new Result();
		try {
			RepairOrder order = new RepairOrder();
			order.setOrder_id(orderId);
			order.setFault_desc(faultDesc);
			order.setFault_device(faultDevice);
			order.setFault_level(faultLevel);
			order.setSys_hash("2");
			repairOrderDao.changeOrder(order);
			result.setMessage("success");

		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("updateOrder error");
		}

		return result;
	}

	@Override
	public DataResult<RepairOrder> getBaseInfoByOrderId(String orderId) {
		DataResult<RepairOrder> dataResult = new DataResult<RepairOrder>();
		try {
			dataResult.setData(repairOrderDao.getOrderById(orderId));
			dataResult.setMessage("success");

		} catch (Exception e) {
			e.printStackTrace();
			dataResult.setCode(Constants.SERVICE_ERROR);
			dataResult.setMessage("getBaseInfoByOrderId error");
		}

		return dataResult;

	}

	@Override
	public Result signInOrder(String userId, String distributionId, String orderId, String signInLocation,
			String signInAddress, String signInImg) {
		Result result = new Result();
		try {
			long time = System.currentTimeMillis();
			RepairTaskDistribution distribution = new RepairTaskDistribution();
			String distributionStatus = repairTaskDistributionDao.getDistributionStatusById(distributionId);
			distribution.setDistribution_id(distributionId);
			distribution.setDistribution_status("已签到");
			distribution.setSign_in_address(signInAddress);
			distribution.setSign_in_img(signInImg);
			distribution.setSign_in_location(signInLocation);
			repairTaskDistributionDao.changeDistributionById(distribution);

			RepairDistributionLog taskLog = new RepairDistributionLog();
			taskLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLogService"));
			taskLog.setDistribution_id(distributionId);
			taskLog.setBefore_status(distributionStatus);
			taskLog.setAfter_status("已签到");
			taskLog.setOperator_time(time);
			taskLog.setOperator_id(userId);
			taskLog.setSys_hash("2");
			repairDistributionLogDao.addDistributionLog(taskLog);

			String orderStatus = repairOrderDao.getOrderStatusById(orderId);
			if (!"待完成".equals(orderStatus)) {

				RepairOrder order = new RepairOrder();
				order.setOrder_id(orderId);
				order.setOrder_status("待完成");
				order.setSys_hash("2");
				repairOrderDao.changeOrder(order);

				RepairOrderLog orderLog = new RepairOrderLog();
				orderLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairLogService"));
				orderLog.setOrder_id(orderId);
				orderLog.setOperator_id(userId);
				orderLog.setOperator_time(time);
				orderLog.setBefore_status(orderStatus);
				orderLog.setAfter_status("待完成");
				orderLog.setSys_hash("2");
				repairOrderLogDao.addOrderLog(orderLog);

			}
			result.setMessage("success");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("signInOrder error");
		}

		return result;
	}

	
	@Override
	public Result completeOrder(String userId,String taskId,String orderId,String faultReason,String faultDevice,String deviceChange,
			String  record,int isRestorePower,String imgUrl) {
		Result result = new Result();
		try {
			long time = System.currentTimeMillis();
			List<String>  distributionIdList= repairTaskDistributionDao.getDistributionIdByTaskId(taskId);
			repairTaskDistributionDao.changeDistributionStatusByTaskId(taskId,"已完成");
			
			List<RepairDistributionLog> repairDistributionLogList = new ArrayList<>();
			for(String distributionId:distributionIdList){
				Thread.sleep(1);
				RepairDistributionLog Log = new RepairDistributionLog();
				Log.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLogService"));
				Log.setDistribution_id(distributionId);
				Log.setOperator_id(userId);
				Log.setOperator_time(time);
				Log.setSys_hash("1");
				Log.setBefore_status("待完成");
				Log.setAfter_status("已完成");
				repairDistributionLogList.add(Log);	
			}
			repairDistributionLogDao.addDistributionLogList(repairDistributionLogList);
			
			String orderStatus = repairOrderDao.getOrderStatusById(orderId);
			RepairOrder order = new RepairOrder();
			order.setOrder_id(orderId);
			order.setOrder_status("已完成");
			order.setSys_hash("2");
			repairOrderDao.changeOrder(order);

			RepairOrderLog orderLog = new RepairOrderLog();
			orderLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairLogService"));
			orderLog.setOrder_id(orderId);
			orderLog.setOperator_id(userId);
			orderLog.setOperator_time(time);
			orderLog.setBefore_status(orderStatus);
			orderLog.setAfter_status("已完成");
			orderLog.setSys_hash("2");
			repairOrderLogDao.addOrderLog(orderLog);
			
			RepairTaskResult repairTaskResult=new RepairTaskResult();
			repairTaskResult.setResult_id(ZRIGenerater.generate("zhy/t_RepairTaskResultService"));
			repairTaskResult.setTask_id(taskId);
			repairTaskResult.setFault_device(faultDevice);
			repairTaskResult.setFault_reason(faultReason);
			repairTaskResult.setDevice_change(deviceChange);
			repairTaskResult.setRecord(record);
			repairTaskResult.setIs_restore_power(isRestorePower);
			repairTaskResult.setComplete_time(time);
			repairTaskResult.setImgUrl(imgUrl);
			repairTaskResult.setSys_hash("2");
			repairTaskResultDao.addTaskResult(repairTaskResult);
			result.setMessage("success");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("completeOrder error");
		}

		return result;
	}
	
	
	@Override
	public Result delayOrder(String userId, String taskId, String orderId, String faultReason, String faultDevice,
			String deviceChange, String record, int isRestorePower, String imgUrl) {
		Result result = new Result();
		try {
			long time = System.currentTimeMillis();
			List<String>  distributionIdList= repairTaskDistributionDao.getDistributionIdByTaskId(taskId);
			repairTaskDistributionDao.changeDistributionStatusByTaskId(taskId,"已延期");
			
			List<RepairDistributionLog> repairDistributionLogList = new ArrayList<>();
			for(String distributionId:distributionIdList){
				Thread.sleep(1);
				RepairDistributionLog Log = new RepairDistributionLog();
				Log.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLogService"));
				Log.setDistribution_id(distributionId);
				Log.setOperator_id(userId);
				Log.setOperator_time(time);
				Log.setSys_hash("1");
				Log.setBefore_status("待完成");
				Log.setAfter_status("已延期");
				repairDistributionLogList.add(Log);	
			}
			repairDistributionLogDao.addDistributionLogList(repairDistributionLogList);
			
			String orderStatus = repairOrderDao.getOrderStatusById(orderId);
			RepairOrder order = new RepairOrder();
			order.setOrder_id(orderId);
			order.setOrder_status("请延期");
			order.setSys_hash("2");
			repairOrderDao.changeOrder(order);

			RepairOrderLog orderLog = new RepairOrderLog();
			orderLog.setLog_id(ZRIGenerater.generate("zhy/t_RepairLogService"));
			orderLog.setOrder_id(orderId);
			orderLog.setOperator_id(userId);
			orderLog.setOperator_time(time);
			orderLog.setBefore_status(orderStatus);
			orderLog.setAfter_status("请延期");
			orderLog.setSys_hash("2");
			repairOrderLogDao.addOrderLog(orderLog);
			
			RepairTaskResult repairTaskResult=new RepairTaskResult();
			repairTaskResult.setResult_id(ZRIGenerater.generate("zhy/t_RepairTaskResultService"));
			repairTaskResult.setTask_id(taskId);
			repairTaskResult.setFault_device(faultDevice);
			repairTaskResult.setFault_reason(faultReason);
			repairTaskResult.setDevice_change(deviceChange);
			repairTaskResult.setRecord(record);
			repairTaskResult.setIs_restore_power(isRestorePower);
			repairTaskResult.setComplete_time(time);
			repairTaskResult.setImgUrl(imgUrl);
			repairTaskResult.setSys_hash("2");
			repairTaskResultDao.addTaskResult(repairTaskResult);
			result.setMessage("success");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("completeOrder error");
		}

		return result;
	}
	
	

	@Override
	public ListResult<Map<String, Object>> getContactsByOrderId(String orderId) {
		ListResult<Map<String, Object>> listResult=new ListResult<Map<String, Object>>();
		try {
//			String taskId=  repairTaskDao.getNewstaskIdByOrderId(orderId);
//			List<RepairTaskDistribution> list=repairTaskDistributionDao.getPeoplesByTaskId(taskId);
//			List<Map<String,Object>> rslist=new ArrayList<Map<String,Object>>();
//			
//			for(RepairTaskDistribution task:list){
//				Employee employee = employeeService.getEmployeeById(task.getElectrician_id()).getData();
//				Map<String,Object> eMap=new HashMap<>();
//				if(task.isIs_primary()){	
//				eMap.put("type","responser");
//				eMap.put("name", employee.getName());
//				eMap.put("phone", employee.getCellphone());
//				rslist.add(eMap);
//				}else{
//				eMap.put("type","cooperator");
//				eMap.put("name", employee.getName());
//				eMap.put("phone", employee.getCellphone());	
//				rslist.add(eMap);
//				}
//			}
//			
//			RepairOrder repairOrder=   repairOrderDao.getOrderById(orderId);   
//			Map<String,Object> eMap=new HashMap<>();
//			eMap.put("type","manager");
//			eMap.put("name", repairOrder.getPowerClient_manager());
//			eMap.put("phone", repairOrder.getManager_phone());
//			rslist.add(eMap);
//			
//			Employee inputter = employeeService.getEmployeeById(repairOrder.getInputter()).getData();
//			Map<String,Object> cMap=new HashMap<>();
//			cMap.put("type","inputter");
//			cMap.put("name", inputter.getName());
//			cMap.put("phone", inputter.getCellphone());
//			rslist.add(cMap);
//			
//			Employee sender = employeeService.getEmployeeById(repairTaskDao.getSenderByOrderId(taskId)).getData();
//			Map<String,Object> dMap=new HashMap<>();
//			dMap.put("type","sender");
//			dMap.put("name", sender.getName());
//			dMap.put("phone", sender.getCellphone());
//			rslist.add(dMap);
//			
//			listResult.setDataList(rslist);
			listResult.setMessage("success");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			listResult.setCode(Constants.SERVICE_ERROR);
			listResult.setMessage("getContactsByOrderId error");
		}	
		return listResult;
	}



	
	



}
