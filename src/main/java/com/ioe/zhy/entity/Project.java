package com.ioe.zhy.entity;

/**
 * Created by wangqiyun on 2017/1/17.
 */
public class Project {
    private long id;
    private String record_id;
    private String category;
    private String content;
    private String result;
    private boolean status;
    private long create_time=System.currentTimeMillis();
    private String powerClient_id;
    private String electrician_id;
    private String service_company_id;
    private long sys_create_time=System.currentTimeMillis();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public String getPowerClient_id() {
        return powerClient_id;
    }

    public void setPowerClient_id(String powerClient_id) {
        this.powerClient_id = powerClient_id;
    }

    public String getElectrician_id() {
        return electrician_id;
    }

    public void setElectrician_id(String electrician_id) {
        this.electrician_id = electrician_id;
    }

    public String getService_company_id() {
        return service_company_id;
    }

    public void setService_company_id(String service_company_id) {
        this.service_company_id = service_company_id;
    }

    public long getSys_create_time() {
        return sys_create_time;
    }

    public void setSys_create_time(long sys_create_time) {
        this.sys_create_time = sys_create_time;
    }
}
