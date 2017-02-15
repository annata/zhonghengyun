/**
 * 
 */
package com.ioe.zhy.service;

import java.util.Map;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;
import com.ioe.zhy.entity.RepairOrder;
import com.ioe.zhy.util.DataResult;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.Result;

/**
 * @author hq
 *
 */
public interface RepairService {
	
	
	
	
	/**
	 * 查询用户的待办工单
	 * @param  role   用户角色
	 * @param companyId  公司id
	 * @param userId   用户的id
	 * @return   
	 */
	public  ListResult<RepairOrder>   getTodoListByUserId(String companyId,String userId,String role);
	
	
	/**
	 * 工单编辑
	 * @Title: updateOrder 
	 * @param orderId 工单id 
	 * @param faultDevice 故障设备 
	 * @param faultDesc 故障描述
	 * @param faultLevel 故障等级
	 * @return   
	 * @throws
	 */
	public Result updateOrder(String orderId,String faultDevice,String faultDesc,String faultLevel);
	
	/**
	 * 工单忽略
	 * @Title: ignoreOrder 
	 * @param orderId 工单的id 
	 * @param operator 操作人id
	 * @param remark 忽略原因
	 * @return   
	 * @throws
	 */
	public Result ignoreOrder(String orderId,String operator,String remark);
	
	
	/**
	 * 工单派发
	 * @Title: sendOrder 
	 * @param orderId  工单的id
	 * @param operator 操作人id
	 * @param needPowerOff 是否需要停电 
	 * @param powerOffTime 停电时间
	 * @param primaryElectrician 抢修负责人
	 * @param cooperateElectrician 抢修配合人员，多个用,分开
	 * @return   
	 * @throws
	 */
	public Result sendOrder(String orderId,String operator,Boolean needPowerOff,String powerOffTime,String primaryElectrician,String cooperateElectrician);
	
	
	/**
	 * 录入工单的基本信息
	 * @Title: addOrder 
	 * @param operator    录入人
	 * @param powerClientId  用电客户id 
	 * @param powerClientManager 站点负责人
	 * @param managePhone  联系电话 
	 * @param faultSource 故障来源
	 * @param faultDevice 故障设备
	 * @param faultDesc  故障描述
	 * @param faultLevel 故障等级
	 * @param areaElectrician  区域电工
	 * @return   
	 */
	public Result addOrder(String operator,String powerClientId,String powerClientManager,
			String managePhone,String faultSource,String faultDevice,String faultDesc,String faultLevel,String areaElectrician);

	
	/**
	 * 接单
	 * @Title: receiveOrder 
	 * @param userId 用户 id 
	 * @param distributionId 工单任务id 
	 * @param orderId  工单的id
	 * @return   
	 * @throws
	 */
	public Result receiveOrder(String userId,String distributionId,String  orderId);
	
	/**
	 * 回退
	 * @Title: refuseOrder 
	 * @param userId  用户的id
	 * @param distributionId  任务的id
	 * @param orderId  工单的id
	 * @param remark  回退原因
	 * @return   
	 * @throws
	 */
	public Result refuseOrder(String userId,String distributionId,String  orderId,String remark);
	
	
	/**
	 * 根据工单查询工单基本信息
	 * @Title: getBaseInfoByOrderId 
	 * @param orderId  工单id
	 * @return   
	 * @throws
	 */
	public DataResult<RepairOrder>  getBaseInfoByOrderId(String orderId);
	
	
	/**
	 *  签到 
	 * @Title: signInOrder  
	 * @param userId  用户的id 
	 * @param distributionId  任务的id 
	 * @param orderId      工单的id 
	 * @param signInLocation    经纬度
	 * @param signInAddress   地址
	 * @param signInImg     照片地址
	 * @return   
	 * @throws
	 */
	public Result signInOrder(String userId,String distributionId,String orderId,String signInLocation,String signInAddress,String signInImg);

	
	/**
	 * 根据工单查询通讯录
	 * @Title: getContactsByOrderId 
	 * @param orderId 工单id
	 * @return   
	 * @throws
	 */
	public ListResult<Map<String, Object>> getContactsByOrderId(String  orderId);
}
