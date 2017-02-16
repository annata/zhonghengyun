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
    public Object addOrder(String orderId){
    	Result result=RepairService.getContactsByOrderId(orderId);
  
        return result;
    }

}
