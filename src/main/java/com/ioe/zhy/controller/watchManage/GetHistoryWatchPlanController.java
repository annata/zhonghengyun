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
public class GetHistoryWatchPlanController {
	
	@Resource
	private WatchManageService watchManageService;
	
	@RequestMapping("/getHistoryWatchPlan")
	@ResponseBody
	public Result execute(String userId,long startTime,long endTime, Integer  pageIndex,Integer pageSize){
	
		Result dataResult=watchManageService.getHistoryWatchPlan(userId, startTime,endTime,pageIndex, pageSize);
	
		return dataResult;	

}

}
