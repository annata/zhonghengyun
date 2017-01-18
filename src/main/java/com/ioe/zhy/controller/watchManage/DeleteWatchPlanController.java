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
public class DeleteWatchPlanController {
	@Resource
	private WatchManageService watchManageService;
	
	@RequestMapping("/deleteWatch")
	@ResponseBody
	public Result execute(String planId){
	
		Result dataResult=watchManageService.deleteWatchPlan(planId);
	
		return dataResult;	
		
	}

}
