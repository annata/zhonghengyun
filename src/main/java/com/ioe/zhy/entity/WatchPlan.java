/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class WatchPlan {
	private String plan_id;		//计划id
	private String area_id;     //区域id，电工值班计划用的到
	private long start_time;    //计划开始时间
	private long end_time;      //计划结束时间   
	private String  watcher;          //值班人
	private String  watch_leader;              //值班领导
	private boolean type;              //值班计划类型，0表示客服值班计划，1表示电工值班计划
	private boolean sys_record_status;     //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private Date sys_create_time;           //添加时间
	private String sys_hash;
	public String getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
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
	public String getWatcher() {
		return watcher;
	}
	public void setWatcher(String watcher) {
		this.watcher = watcher;
	}
	public String getWatch_leader() {
		return watch_leader;
	}
	public void setWatch_leader(String watch_leader) {
		this.watch_leader = watch_leader;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
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
		return "WatchPlan [plan_id=" + plan_id + ", area_id=" + area_id + ", start_time=" + start_time + ", end_time="
				+ end_time + ", watcher=" + watcher + ", watch_leader=" + watch_leader + ", type=" + type
				+ ", sys_record_status=" + sys_record_status + ", sys_last_modified_time=" + sys_last_modified_time
				+ ", sys_create_time=" + sys_create_time + ", sys_hash=" + sys_hash + "]";
	}            




	

}
