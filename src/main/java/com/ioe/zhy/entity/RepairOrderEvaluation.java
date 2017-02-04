/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class RepairOrderEvaluation {
	private String evaluation_id;  //工单评价id
	private String order_id;  //对应的任务编号
	private int attitude;  //服务态度
	private int  speed;       //服务速度
	private int quality;     //服务质量
	private int total;  //总体评价
	private String advice;  //宝贵意见
	private boolean sys_record_status;         //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private String sys_hash;
	private Date  sys_create_time;           //添加时间
	public String getEvaluation_id() {
		return evaluation_id;
	}
	public void setEvaluation_id(String evaluation_id) {
		this.evaluation_id = evaluation_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getAttitude() {
		return attitude;
	}
	public void setAttitude(int attitude) {
		this.attitude = attitude;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
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
		return "RepairOrderEvaluation [evaluation_id=" + evaluation_id + ", order_id=" + order_id + ", attitude="
				+ attitude + ", speed=" + speed + ", quality=" + quality + ", total=" + total + ", advice=" + advice
				+ ", sys_record_status=" + sys_record_status + ", sys_last_modified_time=" + sys_last_modified_time
				+ ", sys_hash=" + sys_hash + ", sys_create_time=" + sys_create_time + "]";
	}
	
	

}
