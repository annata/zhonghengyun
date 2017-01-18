/**
 * 
 */
package com.ioe.zhy.controller.watchManage;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ioe.zhy.service.WatchManageService;
import com.ioe.zhy.util.Result;

/**
 * @author hq
 *
 */
@Controller  
@RequestMapping("/watchManage") 
public class GetWatchPlanController {
	
	@Resource
	private WatchManageService watchManageService;
	
	@RequestMapping("/getWatchPlan")
	@ResponseBody
	public Object execute(String userId){
	
		Object dataResult=watchManageService.getWatchPlan(userId);
	
		return dataResult;	

}
	
}
