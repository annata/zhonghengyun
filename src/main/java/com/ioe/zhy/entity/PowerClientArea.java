package com.ioe.zhy.entity;

import java.util.Date;

/**
 * Created by wangqiyun on 2017/1/20.
 */
public class PowerClientArea {
    private long id;
    private String powerClient_id;
    private String area_id;
    private Date sys_create_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPowerClient_id() {
        return powerClient_id;
    }

    public void setPowerClient_id(String powerClient_id) {
        this.powerClient_id = powerClient_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public Date getSys_create_time() {
        return sys_create_time;
    }

    public void setSys_create_time(Date sys_create_time) {
        this.sys_create_time = sys_create_time;
    }
}
