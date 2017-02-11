/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class RepairTaskDistribution {
	private String distribution_id;
	private String order_id;       //对应报修单id
	private String task_id;            //任务编号，同一次派单产生多个任务，任务编号相同
	private String electrician_id;         //电工id
	private boolean is_primary;            //是否为主要负责人
	private String sign_in_location;       //抢修距离,单位千米
	private String sign_in_address;        //签到地址
	private String sign_in_img;           //签到照片
	private String distribution_status;		//任务状态
	private boolean sys_record_status;     //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private Date sys_create_time=new Date();        //添加时间
//	private String sys_hash; 
	public String getDistribution_id() {
		return distribution_id;
	}
	public void setDistribution_id(String distribution_id) {
		this.distribution_id = distribution_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getElectrician_id() {
		return electrician_id;
	}
	public void setElectrician_id(String electrician_id) {
		this.electrician_id = electrician_id;
	}
	public boolean isIs_primary() {
		return is_primary;
	}
	public void setIs_primary(boolean is_primary) {
		this.is_primary = is_primary;
	}

	public Date getSys_last_modified_time() {
		return sys_last_modified_time;
	}
	public void setSys_last_modified_time(Date sys_last_modified_time) {
		this.sys_last_modified_time = sys_last_modified_time;
	}
	public Date getSys_create_time() {
		return sys_create_time;
	}
	public void setSys_create_time(Date sys_create_time) {
		this.sys_create_time = sys_create_time;
	}
	public String getSign_in_location() {
		return sign_in_location;
	}
	public void setSign_in_location(String sign_in_location) {
		this.sign_in_location = sign_in_location;
	}
	public String getSign_in_address() {
		return sign_in_address;
	}
	public void setSign_in_address(String sign_in_address) {
		this.sign_in_address = sign_in_address;
	}
	public String getSign_in_img() {
		return sign_in_img;
	}
	public void setSign_in_img(String sign_in_img) {
		this.sign_in_img = sign_in_img;
	}
	public String getDistribution_status() {
		return distribution_status;
	}
	public void setDistribution_status(String distribution_status) {
		this.distribution_status = distribution_status;
	}
	public boolean isSys_record_status() {
		return sys_record_status;
	}
	public void setSys_record_status(boolean sys_record_status) {
		this.sys_record_status = sys_record_status;
	}
	
	@Override
	public String toString() {
		return "RepairTaskDistribution [distribution_id=" + distribution_id + ", order_id=" + order_id + ", task_id="
				+ task_id + ", electrician_id=" + electrician_id + ", is_primary=" + is_primary + ", sign_in_location="
				+ sign_in_location + ", sign_in_address=" + sign_in_address + ", sign_in_img=" + sign_in_img
				+ ", distribution_status=" + distribution_status + ", sys_record_status=" + sys_record_status
				+ ", sys_last_modified_time=" + sys_last_modified_time + ", sys_create_time=" + sys_create_time + "]";
	}

}
