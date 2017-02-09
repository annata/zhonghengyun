/**
 * 
 */
package com.ioe.zhy.controller.repairOrder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ioe.zhy.service.RepairService;
import com.ioe.zhy.util.Result;

/**
 * @author hq
 *
 */
@Controller
@RequestMapping("/order")
public class repairOrder {
    @Resource
    RepairService RepairService;
    
    @RequestMapping("/addOrder")
    @ResponseBody
    public Object addOrder(String userId,String powerClientId,String powerClientManager,String managePhone,String faultSource,String faultDevice,String faultDesc,String faultLevel,String areaElectrician){
    	Result result=RepairService.addOrder(userId,powerClientId, powerClientManager, managePhone, faultSource, faultDevice, faultDesc, faultLevel, areaElectrician);
  
        return result;
    }

}
