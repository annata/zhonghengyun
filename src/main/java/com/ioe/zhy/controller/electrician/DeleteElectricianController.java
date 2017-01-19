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
public class DeleteElectricianController {
	@Resource
	private AssetAccountService assetAccountService;
	
	@RequestMapping("/deleteElectrician")
	@ResponseBody
	public Object execute(String electricianId){
	
		Object object=	assetAccountService.deleteElectrician(electricianId);
		
		return object;	
	
}
}
