/**
 * 
 */
package zhonghengyun;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ioe.zhy.dao.ElectricianDao;

/**
 * @author hq
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class One {
	
	   @Resource
	    private ElectricianDao electricianDao;
	
	@Test
	public void test(){
//		electricianDao.deleteElectricianByArea("e");
//		electricianDao.electricianAndArea("zhy/t_AssetAccountService:1484797223780", "314", null);

	}
	  


}
