package com.ioe.zhy.dao;

import com.ioe.zhy.entity.PowerClientArea;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wangqiyun on 2017/1/20.
 */
public interface PowerClientAreaDao {
    boolean add(PowerClientArea powerClientArea);

    boolean delete(PowerClientArea powerClientArea);

    PowerClientArea get(PowerClientArea powerClientArea);

    boolean deleteByArea(@Param("area_id")String area_id);
}
