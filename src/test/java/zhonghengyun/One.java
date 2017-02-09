/**
 * 
 */
package zhonghengyun;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ioe.common.util.ZRIGenerater;
import com.ioe.customer.client.service.EmployeeService;
import com.ioe.zhy.dao.AreaDao;
import com.ioe.zhy.dao.ElectricianDao;
import com.ioe.zhy.dao.PowerClientAreaDao;
import com.ioe.zhy.dao.UserPowerClientFavorDao;
import com.ioe.zhy.entity.Area;
import com.ioe.zhy.entity.PowerClientArea;


/**
 * @author hq
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class One {
    private static final String SERVICE_NAME = "zhy/t_AreaService";
	
	   @Resource
	    private ElectricianDao electricianDao;
	   
	   @Resource
	    private AreaDao areaDao;
	   
	   @Resource
	    private PowerClientAreaDao powerClientAreaDao;
	   
	   @Resource
	    private UserPowerClientFavorDao userPowerClientFavorDao;
	   
	   @Resource
	   private EmployeeService employeeService;
	@Test
	public void test(){
//		System.err.println(electricianDao.electricianIsExist("zhy/t_AssetAccountService:1484797223780"));
//		electricianDao.electricianAndArea("zhy/t_AssetAccountService:1484797223780", "314", null);
//	    Area area = new Area();
//        area.setArea_id("zhy/t_AreaService:1486449534615");
//        area.setArea_name("杭州111111");
//        area.setCompany_id("公司111");
//        area.setSys_hash("13");
//		PowerClientArea powerClientArea=new PowerClientArea();
//		powerClientArea.setArea_id("tet");
//		powerClientArea.setPowerClient_id("嘎");
//		System.out.println(powerClientAreaDao.deleteByArea("tet"));
		
//	   System.err.println(areaDao.getByCompanyId("公司").toString());

//		userPowerClientFavorDao.addFavorPowerClient("dfe", "fege");
//		System.err.println(userPowerClientFavorDao.FavorPowerClientIsExist("dfe", "fege"));
		System.out.println(employeeService.getEmployeeById("ee").toString());
	}
	  


}
