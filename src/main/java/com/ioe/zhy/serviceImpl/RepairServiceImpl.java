/**
 * 
 */
package com.ioe.zhy.serviceImpl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ioe.common.util.Constants;
import com.ioe.common.util.ZRIGenerater;
import com.ioe.zhy.dao.RepairOrderDao;
import com.ioe.zhy.dao.RepairOrderLogDao;
import com.ioe.zhy.entity.RepairOrder;
import com.ioe.zhy.entity.RepairOrderLog;

import com.ioe.zhy.service.RepairLogService;
import com.ioe.zhy.service.RepairService;

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
	private RepairLogService repairLogService;

	@Override
	public ListResult<RepairOrder> getTodoListByUserId(String companyId, String userId) {
		ListResult<RepairOrder> listResult = new ListResult<>();

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
	public Result sendOrder(String orderId, String operator, String needPowerOff, long powerOffTime,
			String primaryElectrician, String cooperateElectrician) {
		Result result = new Result();
		try {
			
			
		} catch (Exception e) {

			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("sendOrder error");
		}
		return result;
		
	}

}
