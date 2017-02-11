package com.ioe.zhy.service;

import com.ioe.zhy.entity.Project;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.PageResult;
import com.ioe.zhy.util.Result;

/**
 * Created by wangqiyun on 2017/1/18.
 */
public interface ProjectService {
	
	/**
	 * 保存检查结果
	 * @Title: saveProjectRecord 
	 * @param result    检查结果
	 * @param status    状态
	 * @param powerClientId   用电客户id
	 * @param powerClientName  用电客户名称
	 * @param electricianId   电工id
	 * @param electricianName  电工名字
	 * @param serviceCompanyId  服务商id
	 * @return   
	 */
	public 	Result saveProjectRecord(String result,Integer status, String powerClientId, String powerClientName, String electricianId, String electricianName, String serviceCompanyId);
	
	
	/**
	 * 修改检查结果
	 * @Title: updateProjectRecord 
	 * @param recordId  记录id
	 * @param result  检查结果 
	 * @param status  状态
	 * @return   
	 * @throws
	 */
	public	Result updateProjectRecord(String recordId,  String result, Integer status);
	
	
	/**
	 * 查询检查结果
	 * @Title: getProjectRecord 
	 * @param recordId  结果id
	 * @return   
	 * @throws
	 */
	public	ListResult<Project> getProjectRecord(String recordId);
	
	/**
	 * 获取确认单列表
	 * @Title: getProjectRecordList 
	 * @param companyId  服务商id
	 * @param status  状态
	 * @param pageSize  分页大小 
	 * @param pageIndex  查询第几页
	 * @return   
	 * @throws
	 */
	public PageResult<Project> getProjectRecordList(String companyId,Integer status,int pageSize,int pageIndex);
}
