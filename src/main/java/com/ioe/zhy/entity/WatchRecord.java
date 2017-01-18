/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class WatchRecord {
	private String record_id;
	private String plan_id;
	private String content;
	private boolean type;              //值班计划类型，0表示客服值班计划，1表示电工值班计划
	private boolean sys_is_delete;     //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private Date sys_create_time;           //添加时间
	public String getRecord_id() {
		return record_id;
	}
	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}
	public String getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public boolean isSys_is_delete() {
		return sys_is_delete;
	}
	public void setSys_is_delete(boolean sys_is_delete) {
		this.sys_is_delete = sys_is_delete;
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
	@Override
	public String toString() {
		return "WatchRecord [record_id=" + record_id + ", plan_id=" + plan_id + ", content=" + content + ", type="
				+ type + ", sys_is_delete=" + sys_is_delete + ", sys_last_modified_time=" + sys_last_modified_time
				+ ", sys_create_time=" + sys_create_time + "]";
	}

	
}
