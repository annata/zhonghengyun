/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

import javassist.expr.NewArray;

/**
 * @author hq
 *
 */
public class WatchRecord {
	private String record_id;
	private String watcher_id;
	private String plan_id;
	private long start_time;
	private long end_time;
	private String content;					
	private boolean is_leader;              //是否为领导
	private boolean sys_is_delete;     //是否删除

	
	public String getRecord_id() {
		return record_id;
	}
	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}
	public String getWatcher_id() {
		return watcher_id;
	}
	public void setWatcher_id(String watcher_id) {
		this.watcher_id = watcher_id;
	}
	public String getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}
	public long getStart_time() {
		return start_time;
	}
	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}
	public long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isIs_leader() {
		return is_leader;
	}
	public void setIs_leader(boolean is_leader) {
		this.is_leader = is_leader;
	}
	public boolean isSys_is_delete() {
		return sys_is_delete;
	}
	public void setSys_is_delete(boolean sys_is_delete) {
		this.sys_is_delete = sys_is_delete;
	}

			

	@Override
	public String toString() {
		return "WatchRecord [record_id=" + record_id + ", watcher_id=" + watcher_id + ", plan_id=" + plan_id
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", content=" + content + ", is_leader="
				+ is_leader + ", sys_is_delete=" + sys_is_delete +  "]";
	}
}
