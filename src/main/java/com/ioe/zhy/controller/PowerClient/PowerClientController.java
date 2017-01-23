/**
 * 
 */
package com.ioe.zhy.controller.PowerClient;

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
@RequestMapping("/powerClient") 
public class PowerClientController {
	@Resource
	private AssetAccountService assetAccountService;
	
	@RequestMapping("/addFavorPowerClient")
	@ResponseBody
	public Object execute(String userId,String powerClientId){
	
		Object object=	assetAccountService.addFavorPowerClient(userId, powerClientId);
		return object;	

}
	
	
	@RequestMapping("/cancelFavorPowerClient")
	@ResponseBody
	public Object cancelFavorPowerClient(String userId,String powerClientId){
	
		Object object=	assetAccountService.cancelFavorPowerClient(userId, powerClientId);
		return object;	

}
	
}