/**
 * 
 */
package zhonghengyun;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ioe.common.util.ZRIGenerater;
import com.ioe.zhy.dao.AreaDao;
import com.ioe.zhy.dao.RepairOrderDao;
import com.ioe.zhy.dao.RepairOrderLogDao;
import com.ioe.zhy.entity.RepairOrder;
import com.ioe.zhy.entity.RepairOrderLog;
import com.ioe.zhy.service.RepairLogService;
import com.ioe.zhy.service.RepairService;
import com.ioe.zhy.util.ChineseCharToEn;
import com.ioe.zhy.util.Result;

/**
 * @author hq
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class OrderTest {
    private static final String SERVICE_NAME = "zhy/t_RepairLogService";
    
    
    	@Resource
    	private RepairOrderLogDao repairOrderLogDao;
	   
	   @Resource
	   private RepairService repairService;
	   
	   
	   @Resource
	   private RepairOrderDao repairOrderDao;
	   
	   @Test
	   public void test1(){
		  

//	 Result result=  repairService.addOrder("为啥是这样", "年", "联系人", "1234656", "来源", "ddfs", "er", "一般", "er");
//		System.out.println(result.toString());
//		   RepairOrderLog repairOrderLog=new RepairOrderLog();
//		   repairOrderLog.setOrder_id("zhy/t_RepairService:1486621082656");
//		   repairOrderLog.setOperator_id("史诗");
//		   repairOrderLog.setOperator_time(System.currentTimeMillis());
//		   repairOrderLogDao.changeOrderLog(repairOrderLog);
		   repairService.ignoreOrder("zhy/t_RepairService:1486621165772", "诸葛", "不知道什么原因");
	   }
}
