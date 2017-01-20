package com.ioe.zhy.dao;

import com.ioe.zhy.entity.PowerClientArea;

/**
 * Created by wangqiyun on 2017/1/20.
 */
public interface PowerClientAreaDao {
    boolean add(String area_id, String powerClient_id);

    boolean delete(String area_id, String powerClient_id);

    PowerClientArea get(String area_id, String powerClient_id);
}
