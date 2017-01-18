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
public class WatchManageController {
	
	@Resource
	private WatchManageService watchManageService;

	
	@RequestMapping("/getWatchRecordByPlanId")
	@ResponseBody
	public Object execute(String planId){
	
		Object dataResult=watchManageService.getWatchRecordByPlanId(planId);
	
		return dataResult;	
	}
}
