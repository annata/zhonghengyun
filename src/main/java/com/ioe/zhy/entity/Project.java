package com.ioe.zhy.entity;

import java.util.Date;

/**
 * Created by wangqiyun on 2017/1/17.
 */
public class Project {
	private String record_id;     
	private String result;     //检查结果
	private int status;      //数据是否正常，0表示不正常，1表示正常
	private long save_time;		//数据保存的时间
	private String powerClient_id;     //对应用电客户的id
	private String powerClient_name;     //用电客户名字
	private String electrician_id;      //录入的电工
	private String electrician_name;    //电工名字
	private String service_company_id;    //服务商企业id
	private boolean sys_record_status;     //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private Date sys_create_time=new Date();        //添加时间
	private String sys_hash;
	
	
	
	public String getRecord_id() {
		return record_id;
	}



	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public int isStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public long getSave_time() {
		return save_time;
	}



	public void setSave_time(long save_time) {
		this.save_time = save_time;
	}



	public String getPowerClient_id() {
		return powerClient_id;
	}



	public void setPowerClient_id(String powerClient_id) {
		this.powerClient_id = powerClient_id;
	}



	public String getPowerClient_name() {
		return powerClient_name;
	}



	public void setPowerClient_name(String powerClient_name) {
		this.powerClient_name = powerClient_name;
	}



	public String getElectrician_id() {
		return electrician_id;
	}



	public void setElectrician_id(String electrician_id) {
		this.electrician_id = electrician_id;
	}



	public String getElectrician_name() {
		return electrician_name;
	}



	public void setElectrician_name(String electrician_name) {
		this.electrician_name = electrician_name;
	}



	public String getService_company_id() {
		return service_company_id;
	}



	public void setService_company_id(String service_company_id) {
		this.service_company_id = service_company_id;
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
		return "Project [record_id=" + record_id + ", result=" + result + ", status=" + status + ", save_time="
				+ save_time + ", powerClient_id=" + powerClient_id + ", powerClient_name=" + powerClient_name
				+ ", electrician_id=" + electrician_id + ", electrician_name=" + electrician_name
				+ ", service_company_id=" + service_company_id + ", sys_record_status=" + sys_record_status
				+ ", sys_last_modified_time=" + sys_last_modified_time + ", sys_create_time=" + sys_create_time
				+ ", sys_hash=" + sys_hash + "]";
	}
	
}
