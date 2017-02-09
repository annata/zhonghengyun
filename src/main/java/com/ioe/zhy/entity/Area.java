package com.ioe.zhy.entity;

import java.util.Date;

/**
 * Created by wangqiyun on 2017/1/18.
 */
public class Area {
    private long id;
    private String area_id;
    private String company_id;
    private String area_name;
    private Date sys_create_time = new Date();
    private boolean sys_record_status;
    private String sys_hash;
	private Date sys_last_modified_time;  

    @Override
	public String toString() {
		return "Area [id=" + id + ", area_id=" + area_id + ", company_id=" + company_id + ", area_name=" + area_name
				+ ", sys_create_time=" + sys_create_time + ", sys_record_status=" + sys_record_status + ", sys_hash="
				+ sys_hash + ", sys_last_modified_time=" + sys_last_modified_time + "]";
	}

	public String getSys_hash() {
		return sys_hash;
	}

	public void setSys_hash(String sys_hash) {
		this.sys_hash = sys_hash;
	}

	public Date getSys_last_modified_time() {
		return sys_last_modified_time;
	}

	public void setSys_last_modified_time(Date sys_last_modified_time) {
		this.sys_last_modified_time = sys_last_modified_time;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public Date getSys_create_time() {
        return sys_create_time;
    }

    public void setSys_create_time(Date sys_create_time) {
        this.sys_create_time = sys_create_time;
    }

	public boolean isSys_record_status() {
		return sys_record_status;
	}

	public void setSys_record_status(boolean sys_record_status) {
		this.sys_record_status = sys_record_status;
	}


}
