/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class RrepairTask {
	private String task_id;
	private String order_id;
	private String sender;   //派发人
	private long send_time; //派发时间
	private boolean need_powerOff; //是否需要停电
	private String  powerOff_time; //预计停电时间
	private boolean sys_record_status;     //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private Date sys_create_time=new Date();        //添加时间
	private String sys_hash;
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public long getSend_time() {
		return send_time;
	}
	public void setSend_time(long send_time) {
		this.send_time = send_time;
	}
	public boolean isNeed_powerOff() {
		return need_powerOff;
	}
	public void setNeed_powerOff(boolean need_powerOff) {
		this.need_powerOff = need_powerOff;
	}
	public String getPowerOff_time() {
		return powerOff_time;
	}
	public void setPowerOff_time(String powerOff_time) {
		this.powerOff_time = powerOff_time;
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
	public Date getSys_create_time() {
		return sys_create_time;
	}
	public void setSys_create_time(Date sys_create_time) {
		this.sys_create_time = sys_create_time;
	}
	public String getSys_hash() {
		return sys_hash;
	}
	public void setSys_hash(String sys_hash) {
		this.sys_hash = sys_hash;
	}
	@Override
	public String toString() {
		return "RrepairTask [task_id=" + task_id + ", order_id=" + order_id + ", sender=" + sender + ", send_time="
				+ send_time + ", need_powerOff=" + need_powerOff + ", powerOff_time=" + powerOff_time
				+ ", sys_record_status=" + sys_record_status + ", sys_last_modified_time=" + sys_last_modified_time
				+ ", sys_create_time=" + sys_create_time + ", sys_hash=" + sys_hash + "]";
	}

	
}