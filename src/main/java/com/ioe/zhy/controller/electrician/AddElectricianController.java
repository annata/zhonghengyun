/**
 * 
 */
package com.ioe.zhy.controller.electrician;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ioe.zhy.service.AssetAccountService;


/**
 * @author hq
 *
 */
@Controller  
@RequestMapping("/electrician") 
public class AddElectricianController {
	@Resource
	private AssetAccountService assetAccountService;
	
	@RequestMapping("/addElectrician")
	@ResponseBody
	public Object execute(String netLicence,String specialCertificate,String professionalCredential,String areaId,String accountId,String employeeId){
	
		Object object=	assetAccountService.addElectrician(netLicence, specialCertificate, professionalCredential, areaId, accountId, employeeId);
		
		return object;	
	
}

}
