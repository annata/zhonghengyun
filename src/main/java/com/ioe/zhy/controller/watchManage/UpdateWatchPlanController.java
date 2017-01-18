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
public class UpdateWatchPlanController {
	
	@Resource
	private WatchManageService watchManageService;
	
	@RequestMapping("/updateWatchPlan")
	@ResponseBody
	public Result execute(String plan_id, String area_id,long start_time,long end_time,long 
			start_real_time,long end_real_time,long watcher_id,long leader_id,boolean type){
	
		Result dataResult=watchManageService.updateWatchPlan( plan_id,area_id, start_time, end_time, start_real_time, end_real_time, watcher_id, leader_id, type);
	
		return dataResult;	

}

}
