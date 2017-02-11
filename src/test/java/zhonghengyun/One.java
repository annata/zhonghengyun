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
import com.ioe.zhy.dao.ProjectDao;
import com.ioe.zhy.dao.UserPowerClientFavorDao;
import com.ioe.zhy.entity.Area;
import com.ioe.zhy.entity.PowerClientArea;
import com.ioe.zhy.entity.Project;
import com.ioe.zhy.service.ProjectService;


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
	   
//	   @Resource
//	   private EmployeeService employeeService;
	   
	   @Resource
	   private ProjectService projectService;
	   
		@Resource
		private ProjectDao projectDao;
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
//		System.out.println(employeeService.getEmployeeById("ee").toString());
		
		Project project = new Project();
		project.setRecord_id("zhy/t_WatchProjectService:1484721014623");
		project.setResult("zheng");
		project.setStatus(0);
		project.setSave_time(System.currentTimeMillis());
		project.setPowerClient_id("公司id");
		project.setPowerClient_name("公司名字");
		project.setElectrician_id("电工");
		project.setElectrician_name("te");
		project.setService_company_id("ere");
		project.setSys_hash("1");
//		projectDao.addProject(project);
//		projectDao.updateProject(project);
//		System.err.println(projectDao.getProjectById("zhy/t_WatchProjectService:1484721014623"));
//		System.err.println(projectDao.getProjectCount(null, "公司id"));
//		System.err.println(projectDao.getProjectRecordList(null, "公司id", 0, 7).size());
		System.err.println(projectService.getProjectRecordList("公司id", null, 5, 1).getDataList().toString());
		System.err.println(projectService.getProjectRecordList("公司id",null, 5, 1).getLength());
	}
	  


}
