/**
 * 
 */
package com.ioe.zhy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ioe.zhy.entity.Electrician;

/**
 * @author hq
 *
 */
public interface ElectricianDao {
	public int electricianIsExist(String electrician_id);
	public int addElectrician(Electrician electrician);
	public int updateElectrician(Electrician electrician);
	public int deleteElectrician(@Param("electrician_id")String electrician_id,@Param("sys_hash")String sys_hash);
	public Electrician getElectricianInfo(String electrician_id);
	public List<Electrician>   getElectricianList(String company_id);
	public List<Electrician>  searchElectrician(@Param("company_id")String company_id,@Param("network_licence")String network_licence,
			@Param("special_certificate")String special_certificate,@Param("professional_credential")String  professional_credential);
 	
	public int deleteElectricianByArea(String area_id);
	
	
	public int electricianAndArea(@Param("electrician_id")String electrician_id,@Param("sys_hash")String sys_hash,@Param("area_id")String area_id);
}
