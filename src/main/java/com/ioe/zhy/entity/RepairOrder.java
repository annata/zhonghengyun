/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class RepairOrder {
	private String order_id; //工单id
	private String order_no; //工单编号
	private  String powerClient_id; //用电用户id
	private String powerClient_manager; //用户负责人
	private String manager_phone;   //用户电话
	private String fault_source;  //故障来源：用户上报、客服录入、平台生成
	private String fault_device;  //故障设备
	private String fault_desc;  //故障描述
	private String fault_level;  //紧急程度：严重、紧急、一般
	private String area_electrician; //区域电工
	private String order_status;  //报修状态：已处理和未处理。当没有派单或者已派工单状态为已延期时，视为未处理
	private String inputter;   //受理人
	private boolean sys_record_status;         //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private String sys_hash;
	private Date  sys_create_time;           //添加时间
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getPowerClient_id() {
		return powerClient_id;
	}
	public void setPowerClient_id(String powerClient_id) {
		this.powerClient_id = powerClient_id;
	}
	public String getPowerClient_manager() {
		return powerClient_manager;
	}
	public void setPowerClient_manager(String powerClient_manager) {
		this.powerClient_manager = powerClient_manager;
	}
	public String getManager_phone() {
		return manager_phone;
	}
	public void setManager_phone(String manager_phone) {
		this.manager_phone = manager_phone;
	}
	public String getFault_source() {
		return fault_source;
	}
	public void setFault_source(String fault_source) {
		this.fault_source = fault_source;
	}
	public String getFault_device() {
		return fault_device;
	}
	public void setFault_device(String fault_device) {
		this.fault_device = fault_device;
	}
	public String getFault_desc() {
		return fault_desc;
	}
	public void setFault_desc(String fault_desc) {
		this.fault_desc = fault_desc;
	}
	public String getFault_level() {
		return fault_level;
	}
	public void setFault_level(String fault_level) {
		this.fault_level = fault_level;
	}
	public String getArea_electrician() {
		return area_electrician;
	}
	public void setArea_electrician(String area_electrician) {
		this.area_electrician = area_electrician;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getInputter() {
		return inputter;
	}
	public void setInputter(String inputter) {
		this.inputter = inputter;
	}
	public boolean isSys_record_status() {
		return sys_record_status;
	}
	public void setSys_record_status(boolean sys_record_status) {
		this.sys_record_status = sys_record_status;
	}
	public Date getSys_last_modified_time() {
		return sys_last_modified_time;
	}
	public void setSys_last_modified_time(Date sys_last_modified_time) {
		this.sys_last_modified_time = sys_last_modified_time;
	}
	public String getSys_hash() {
		return sys_hash;
	}
	public void setSys_hash(String sys_hash) {
		this.sys_hash = sys_hash;
	}
	public Date getSys_create_time() {
		return sys_create_time;
	}
	public void setSys_create_time(Date sys_create_time) {
		this.sys_create_time = sys_create_time;
	}
	@Override
	public String toString() {
		return "RepairOrder [order_id=" + order_id + ", order_no=" + order_no + ", powerClient_id=" + powerClient_id
				+ ", powerClient_manager=" + powerClient_manager + ", manager_phone=" + manager_phone
				+ ", fault_source=" + fault_source + ", fault_device=" + fault_device + ", fault_desc=" + fault_desc
				+ ", fault_level=" + fault_level + ", area_electrician=" + area_electrician + ", order_status="
				+ order_status + ", inputter=" + inputter + ", sys_record_status=" + sys_record_status
				+ ", sys_last_modified_time=" + sys_last_modified_time + ", sys_hash=" + sys_hash + ", sys_create_time="
				+ sys_create_time + "]";
	}
	
	
}
