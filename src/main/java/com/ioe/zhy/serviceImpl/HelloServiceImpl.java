/**
 * 
 */
package com.ioe.zhy.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ioe.zhy.dao.HelloDao;
import com.ioe.zhy.service.HelloService;
import com.ioe.zhy.util.DataResult;

/**
 * @author hq
 *
 */
@Service("helloService")
@Transactional
public class HelloServiceImpl implements HelloService {

	
	@Resource
	private HelloDao helloDao;
	
	public DataResult<String> sayHello() {
		DataResult<String>  dataResult=new DataResult<String>();
		dataResult.setData(helloDao.sayHello(1));
		return dataResult;
	}

}
