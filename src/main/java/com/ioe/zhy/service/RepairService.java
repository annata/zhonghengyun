/**
 * 
 */
package com.ioe.zhy.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;
import com.ioe.zhy.entity.RepairOrder;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.Result;

/**
 * @author hq
 *
 */
public interface RepairService {
	
	/**
	 * 查询用户的待办工单
	 * @param companyId  公司id
	 * @param userId   用户的id
	 * @return   
	 */
	public  ListResult<RepairOrder>   getTodoListByUserId(String companyId,String userId);

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
	public Result sendOrder(String orderId,String operator,String needPowerOff,long powerOffTime,String primaryElectrician,String cooperateElectrician);
	
	
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

}
