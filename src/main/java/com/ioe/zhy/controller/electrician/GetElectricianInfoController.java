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
public class GetElectricianInfoController {
	@Resource
	private AssetAccountService assetAccountService;
	
	@RequestMapping("/getElectricianInfo")
	@ResponseBody
	public Object execute(String electricianId){
	
		Object object=	assetAccountService.getElectricianInfo(electricianId);
		
		return object;	
	
}
}
