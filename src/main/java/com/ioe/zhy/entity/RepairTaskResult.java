/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class RepairTaskResult {
	private String result_id;
	private String task_id;
	private String fault_reason;  //勘察结果
	private String fault_device; //故障点，可能会有多个，以json格式保存
	private String device_change;    //配件更换，json格式
	private String record;           //抢修记录
	private   int  is_restore_power; //是否恢复供电
	private String imgUrl;       //附件最多四张，根据oss外链长度计算
	private long complete_time;                //完成时间
	private boolean sys_record_status;     //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private Date sys_create_time=new Date();        //添加时间
	private String sys_hash;
	public String getResult_id() {
		return result_id;
	}
	public void setResult_id(String result_id) {
		this.result_id = result_id;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getFault_reason() {
		return fault_reason;
	}
	public void setFault_reason(String fault_reason) {
		this.fault_reason = fault_reason;
	}
	public String getFault_device() {
		return fault_device;
	}
	public void setFault_device(String fault_device) {
		this.fault_device = fault_device;
	}
	public String getDevice_change() {
		return device_change;
	}
	public void setDevice_change(String device_change) {
		this.device_change = device_change;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public int getIs_restore_power() {
		return is_restore_power;
	}
	public void setIs_restore_power(int is_restore_power) {
		this.is_restore_power = is_restore_power;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public long getComplete_time() {
		return complete_time;
	}
	public void setComplete_time(long complete_time) {
		this.complete_time = complete_time;
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
		return "RepairTaskResult [result_id=" + result_id + ", task_id=" + task_id + ", fault_reason=" + fault_reason
				+ ", fault_device=" + fault_device + ", device_change=" + device_change + ", record=" + record
				+ ", is_restore_power=" + is_restore_power + ", imgUrl=" + imgUrl + ", complete_time=" + complete_time
				+ ", sys_record_status=" + sys_record_status + ", sys_last_modified_time=" + sys_last_modified_time
				+ ", sys_create_time=" + sys_create_time + ", sys_hash=" + sys_hash + "]";
	}
	
}
