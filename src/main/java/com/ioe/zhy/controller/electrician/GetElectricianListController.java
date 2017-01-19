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
public class GetElectricianListController {
	@Resource
	private AssetAccountService assetAccountService;
	
	@RequestMapping("/getElectricianList")
	@ResponseBody
	public Object execute(String companyId){
	
		Object object=	assetAccountService.getElectricianList(companyId);
		
		return object;	
	
}
}
