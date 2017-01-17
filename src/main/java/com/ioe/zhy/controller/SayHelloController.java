/**
 * 
 */
package com.ioe.zhy.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ioe.zhy.service.HelloService;
import com.ioe.zhy.util.DataResult;



/**
 * @author hq
 *
 */
@Controller  
@RequestMapping("/say") 
public class SayHelloController {
	@Resource
	private HelloService helloService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public DataResult<String> execute(){
	
		DataResult<String> dataResult=new DataResult<String>();
		dataResult=helloService.sayHello();
		System.out.println(dataResult.getData());
		return dataResult;	
	
}

}
