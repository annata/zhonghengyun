package com.ioe.zhy.dao;

import com.ioe.zhy.entity.PowerClientArea;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Created by wangqiyun on 2017/1/20.
 */
public interface PowerClientAreaDao {
    boolean add(PowerClientArea powerClientArea);

    boolean delete(PowerClientArea powerClientArea);

    int get(PowerClientArea powerClientArea);

    boolean deleteByArea(@Param("area_id")String area_id);
    
    public  List<String> getPowerClientIdByAreaId();
}
