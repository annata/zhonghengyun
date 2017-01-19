/**
 * 
 */
package com.ioe.zhy.service;

import com.ioe.zhy.entity.Electrician;
import com.ioe.zhy.util.DataResult;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.Result;

/**
 * @author hq
 *
 */
public interface AssetAccountService {
	
	/**
	 * 新增电工
	 * @param netLicence  进网许可证 
	 * @param specialCertificate  特种作业许可证 
	 * @param professionalCredential 职业资格证书
	 * @param areaId  区域id
	 * @param accountId   account表对应的id
	 * @param employeeId  employee表对应的id
	 * @return   
	 */
	public Result addElectrician(String netLicence,String specialCertificate,String professionalCredential,
			String areaId,String accountId,String employeeId);
	
	
	
	/**
	 * 编辑电工
	 * @param electricianId  电工id
	 * @param netLicence   进网许可证
	 * @param specialCertificate   特种作业许可证
	 * @param professionalCredential   职业资格证书
	 * @param areaId   区域id
	 * @param accountId   account表对应的id 
	 * @param employeeId  employee表对应的id
	 * @return   
	 */
	public Result updateElectrician(String electricianId,String netLicence,String specialCertificate,String professionalCredential,String  areaId,String accountId,String employeeId);

	/**
	 * 删除电工
	 * @param electricianId 电工id
	 * @return   
	 */
	public Result deleteElectrician(String electricianId);
	
	
	
	public DataResult<Electrician> getElectricianInfo(String electricianId);
	
	/**
	 * 查询电工列表
	 * @param companyId  公司的id
	 * @return   
	 */
	public ListResult<Electrician> getElectricianList(String companyId);
}
