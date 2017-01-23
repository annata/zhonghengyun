/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class UserPowerClientFavor {
	private long id;
	private String user_id;
	private String powerClient_id;
	private boolean sys_record_status;     //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private Date sys_create_time;           //添加时间
	private String sys_hash;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPowerClient_id() {
		return powerClient_id;
	}
	public void setPowerClient_id(String powerClient_id) {
		this.powerClient_id = powerClient_id;
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
		return "UserPowerClientFavor [id=" + id + ", user_id=" + user_id + ", powerClient_id=" + powerClient_id
				+ ", sys_record_status=" + sys_record_status + ", sys_last_modified_time=" + sys_last_modified_time
				+ ", sys_create_time=" + sys_create_time + ", sys_hash=" + sys_hash + "]";
	}   
	
	
	
	
	
	
	
	

}
