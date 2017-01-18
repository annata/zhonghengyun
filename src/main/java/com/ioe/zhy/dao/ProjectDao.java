package com.ioe.zhy.dao;

import com.ioe.zhy.entity.Project;

import java.util.List;

/**
 * Created by wangqiyun on 2017/1/17.
 */
public interface ProjectDao {
    boolean addProject(Project project);

    boolean updateProject(Project project);

    List<Project> getProjrct(String powerClientId);
}
