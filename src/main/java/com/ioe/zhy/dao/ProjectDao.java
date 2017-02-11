package com.ioe.zhy.dao;

import com.ioe.zhy.entity.Project;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Created by wangqiyun on 2017/1/17.
 */
public interface ProjectDao {
    public  boolean addProject(Project project);

    public  boolean updateProject(Project project);

    public 	List<Project> getProjectById(String recordId);
    
    public int getProjectCount(@Param("status")Integer status,@Param("powerClient_id")String powerClient_id);

    public 	List<Project> getProjectRecordList(@Param("status")Integer status,@Param("powerClient_id")String powerClient_id,@Param("startNumber")int startNumber,@Param("PageCount")int PageCount);
}
