package com.ioe.zhy.dao;

import com.ioe.zhy.entity.Area;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * Created by wangqiyun on 2017/1/19.
 */
public interface AreaDao {
    boolean add(Area area);

    boolean update(Area area);

    boolean delete(@Param("areaId")String areaId,@Param("sys_hash")String sys_hash);

    List<Map<String, Object>> getByCompanyId(String companyId);

    List<Map<String, Object>> get(String areaId);
}
