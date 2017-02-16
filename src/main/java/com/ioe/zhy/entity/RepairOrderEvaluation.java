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
	private String evaluationId;  //工单评价id
	private String orderId;  //对应的任务编号
	private int attitude;  //服务态度
	private int  speed;       //服务速度
	private int quality;     //服务质量
	private int total;  //总体评价
	private String advice;  //宝贵意见
	private boolean sysRecordStatus;         //是否删除
	private Date sysLastModifiedTime;    //最后一次修改时间
	private String sysHash;
	private Date  sysCreateTime;           //添加时间
	public String getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(String evaluationId) {
		this.evaluationId = evaluationId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public boolean isSysRecordStatus() {
		return sysRecordStatus;
	}
	public void setSysRecordStatus(boolean sysRecordStatus) {
		this.sysRecordStatus = sysRecordStatus;
	}
	public Date getSysLastModifiedTime() {
		return sysLastModifiedTime;
	}
	public void setSysLastModifiedTime(Date sysLastModifiedTime) {
		this.sysLastModifiedTime = sysLastModifiedTime;
	}
	public String getSysHash() {
		return sysHash;
	}
	public void setSysHash(String sysHash) {
		this.sysHash = sysHash;
	}
	public Date getSysCreateTime() {
		return sysCreateTime;
	}
	public void setSysCreateTime(Date sysCreateTime) {
		this.sysCreateTime = sysCreateTime;
	}
	@Override
	public String toString() {
		return "RepairOrderEvaluation [evaluationId=" + evaluationId + ", orderId=" + orderId + ", attitude=" + attitude
				+ ", speed=" + speed + ", quality=" + quality + ", total=" + total + ", advice=" + advice
				+ ", sysRecordStatus=" + sysRecordStatus + ", sysLastModifiedTime=" + sysLastModifiedTime + ", sysHash="
				+ sysHash + ", sysCreateTime=" + sysCreateTime + "]";
	}

	

}
