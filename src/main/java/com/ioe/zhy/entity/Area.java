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
    private boolean sys_is_delete;

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

    public boolean isSys_is_delete() {
        return sys_is_delete;
    }

    public void setSys_is_delete(boolean sys_is_delete) {
        this.sys_is_delete = sys_is_delete;
    }
}
