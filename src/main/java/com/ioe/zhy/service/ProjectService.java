package com.ioe.zhy.service;

import com.ioe.zhy.entity.Project;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.Result;

/**
 * Created by wangqiyun on 2017/1/18.
 */
public interface ProjectService {
    Result saveProjectRecord(String category, String content, String result, boolean status, String powerClientId, String electricianId, String serviceCompanyId);

    Result updateProjectRecord(String recordId, String category, String content, String result, boolean status, String powerClientId, String electricianId, String serviceCompanyId);

    ListResult<Project> getProjectRecord(String powerClientId);
}
