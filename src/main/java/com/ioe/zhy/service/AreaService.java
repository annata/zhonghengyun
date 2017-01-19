package com.ioe.zhy.service;

import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.Result;

import java.util.Map;

/**
 * Created by wangqiyun on 2017/1/19.
 */
public interface AreaService {
    Result addArea(String companyId, String areaName);

    Result updateArea(String areaId, String areaName);

    Result deleteArea(String areaId);

    ListResult<Map<String, Object>> getAreaByCompanyId(String companyId);
}
