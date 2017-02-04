/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class RepairOrderLog {
	private String log_id;   //日志id
	private String order_id;  //对应工单的id
	private String  operator_id; //操作人id
	private String before_status; //操作之前工单状态
	private String after_status; //操作之后的工单状态
	private long operator_time;  //操作时间
	private String remark;   //备注
	private boolean sys_record_status;         //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private String sys_hash;
	private Date  sys_create_time;           //添加时间
	
	
	public String getLog_id() {
		return log_id;
	}



	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}



	public String getOrder_id() {
		return order_id;
	}



	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}



	public String getOperator_id() {
		return operator_id;
	}



	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}



	public String getBefore_status() {
		return before_status;
	}



	public void setBefore_status(String before_status) {
		this.before_status = before_status;
	}



	public String getAfter_status() {
		return after_status;
	}



	public void setAfter_status(String after_status) {
		this.after_status = after_status;
	}



	public long getOperator_time() {
		return operator_time;
	}



	public void setOperator_time(long operator_time) {
		this.operator_time = operator_time;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
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
		return "RepairOrderLog [log_id=" + log_id + ", order_id=" + order_id + ", operator_id=" + operator_id
				+ ", before_status=" + before_status + ", after_status=" + after_status + ", operator_time="
				+ operator_time + ", remark=" + remark + ", sys_record_status=" + sys_record_status
				+ ", sys_last_modified_time=" + sys_last_modified_time + ", sys_hash=" + sys_hash + ", sys_create_time="
				+ sys_create_time + "]";
	}
	

}
