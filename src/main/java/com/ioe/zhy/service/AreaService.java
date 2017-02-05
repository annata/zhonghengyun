package com.ioe.zhy.service;

import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.Result;

import java.util.Map;

/**
 * Created by wangqiyun on 2017/1/19.
 */
public interface AreaService {
	/**
	 * 新增区域
	 * @param companyId  公司id
	 * @param areaName   区域名称
	 * @return   
	 */
    Result addArea(String companyId, String areaName);

    /**
     * 编辑区域
     * @param areaId  区域Id 
     * @param areaName  区域名称
     * @return   
     */
    Result updateArea(String areaId, String areaName);
    
    /**
     * 删除区域
     * @param areaId  区域Id
     * @return   
     * @throws
     */
    Result deleteArea(String areaId);
    
    
    /**
     * 查询区域列表
     * @param companyId 公司Id
     * @return   
     */
    ListResult<Map<String, Object>> getAreaByCompanyId(String companyId);
    	
    /**
     * 绑定电工和区域
     * @param electricianId  电工的id 
     * @param areaId   区域Id
     * @return   
     */
    Result bindElectricianAndArea(String electricianId, String areaId);
    
    /**
     * 解绑电工和区域
     * @param electricianId  电工的id 
     * @param areaId  区域的id
     * @return   
     */
    Result unBindElectricianAndArea(String electricianId, String areaId);
    
    /**
     * 绑定用电客户和区域
     * @param powerClientId  用电客户的id
     * @param areaId  区域的id
     * @return   
     */
    Result bindPowerClientAndArea(String powerClientId, String areaId);
    	
    /**
     *  解绑用电客户和区域 
     * @param powerClientId  用电客户的id 
     * @param areaId  区域的id
     * @return   
     */
    Result unBindPowerClientAndArea(String powerClientId, String areaId);
}
