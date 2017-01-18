/**
 * 
 */
package com.ioe.zhy.entity;

/**
 * @author hq
 *
 */
public class WatchPlan {
	private long id;
	private String plan_id;		//计划id
	private String area_id;     //区域id，电工值班计划用的到
	private long start_time;    //计划开始时间
	private long end_time;      //计划结束时间   
	private long start_real_time;  //实际开始时间
	private long end_real_time;     //实际结束时间
	private long watcher_id;          //值班人
	private long leader_id;              //值班领导
	private boolean type;              //值班计划类型，0表示客服值班计划，1表示电工值班计划
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public long getStart_real_time() {
		return start_real_time;
	}
	public void setStart_real_time(long start_real_time) {
		this.start_real_time = start_real_time;
	}
	public long getEnd_real_time() {
		return end_real_time;
	}
	public void setEnd_real_time(long end_real_time) {
		this.end_real_time = end_real_time;
	}
	public long getWatcher_id() {
		return watcher_id;
	}
	public void setWatcher_id(long watcher_id) {
		this.watcher_id = watcher_id;
	}
	public long getLeader_id() {
		return leader_id;
	}
	public void setLeader_id(long leader_id) {
		this.leader_id = leader_id;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "WatchPlan [id=" + id + ", plan_id=" + plan_id + ", area_id=" + area_id + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", start_real_time=" + start_real_time + ", end_real_time=" + end_real_time
				+ ", watcher_id=" + watcher_id + ", leader_id=" + leader_id + ", type=" + type + "]";
	}

	

}
