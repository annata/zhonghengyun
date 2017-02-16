/**
 * 
 */
package zhonghengyun;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ioe.common.util.ZRIGenerater;
import com.ioe.zhy.dao.AreaDao;
import com.ioe.zhy.dao.RepairDistributionLogDao;
import com.ioe.zhy.dao.RepairOrderDao;
import com.ioe.zhy.dao.RepairOrderLogDao;
import com.ioe.zhy.dao.RepairTaskDistributionDao;
import com.ioe.zhy.dao.RrepairTaskDao;
import com.ioe.zhy.entity.RepairDistributionLog;
import com.ioe.zhy.entity.RepairOrder;
import com.ioe.zhy.entity.RepairOrderLog;
import com.ioe.zhy.entity.RepairTaskDistribution;
import com.ioe.zhy.entity.RrepairTask;
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
	   
	   @Resource
		private RrepairTaskDao repairTaskDao;
	   
	   @Resource
	   private RepairTaskDistributionDao repairTaskDistributionDao;
	   
	   
	   @Resource
	   private RepairDistributionLogDao repairDistributionLogDao;
	   
	   @Test
	   public void test1() throws InterruptedException{
		  

//	 Result result=  repairService.addOrder("为啥是这样", "年", "联系人", "1234656", "来源", "ddfs", "er", "一般", "er");
//		System.out.println(result.toString());
//		   RepairOrderLog repairOrderLog=new RepairOrderLog();
//		   repairOrderLog.setOrder_id("zhy/t_RepairService:1486621082656");
//		   repairOrderLog.setOperator_id("史诗");
//		   repairOrderLog.setOperator_time(System.currentTimeMillis());
//		   repairOrderLogDao.changeOrderLog(repairOrderLog);
//		   repairService.ignoreOrder("zhy/t_RepairService:1486621165772", "诸葛", "不知道什么原因");
		   
		   
//		   RrepairTask  repairTask=new  RrepairTask();
//			 repairTask.setTask_id(ZRIGenerater.generate("zhy/t_RrepairTask"));
//			 repairTask.setOrder_id("zhy/t_RepairService:1486621181948");
//			 repairTask.setSender("老虎");
//			 repairTask.setSend_time(System.currentTimeMillis());
//			 repairTask.setNeed_powerOff(false);
//			 repairTask.setPowerOff_time("2014-11-12");
//			 repairTask.setSys_hash("1");
//			 repairTaskDao.addTask(repairTask);
//		   List<RepairTaskDistribution> list=new  ArrayList<RepairTaskDistribution>();
//		   RepairTaskDistribution ad=new RepairTaskDistribution();
//		   ad.setDistribution_id(ZRIGenerater.generate("zhy/t_RepairTaskDistribution"));
//		   ad.setOrder_id("zhy/t_RepairService:1486621181948");
//		   ad.setIs_primary(true);
//		   ad.setTask_id("zhy/t_RrepairTask:1486704937539");
//		   ad.setDistribution_status("待接单");
//		   RepairTaskDistribution sdfs=new RepairTaskDistribution();
//		   sdfs.setDistribution_id(ZRIGenerater.generate("zhy/t_RepairTaskDistribution"));
//		   sdfs.setOrder_id("zhy/t_RepairService:1486621181948");
//		   sdfs.setIs_primary(false);
//		   sdfs.setTask_id("zhy/t_RrepairTask:1486704937539");
//		   sdfs.setDistribution_status("待接单");
//		   list.add(sdfs);
//		   list.add(ad);
//		   repairTaskDistributionDao.addTaskDistributionList(list);
//		   List<RepairDistributionLog> list=new ArrayList<>();
//		   RepairDistributionLog r1=new RepairDistributionLog();
//		   r1.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLog"));
//		   r1.setDistribution_id("zhy/t_RepairTaskDistribution:1486707066435");
//		   r1.setSys_hash("1");
//		   r1.setOperator_time(System.currentTimeMillis());
//		   Thread.sleep(12);
//		   RepairDistributionLog r2=new RepairDistributionLog();
//		   r2.setLog_id(ZRIGenerater.generate("zhy/t_RepairDistributionLog"));
//		   r2.setDistribution_id("zhy/t_RepairTaskDistribution:1486707066434");
//		   r2.setSys_hash("1");
//		   r2.setOperator_time(System.currentTimeMillis());
//		   list.add(r2);
//		   list.add(r1);
//		   repairDistributionLogDao.addDistributionLog(list);
		   
		   
		   
		   
//	   repairService.sendOrder("zhy/t_RepairService:1486621181948", "派发人", false, System.currentTimeMillis()+"", "小小", "老大,老二,老三");
//		   System.err.println(  repairService.getTodoListByUserId("年","小小", "用电主管").getDataList().toString());
//		 System.err.println(repairService.refuseOrder("老三", "zhy/t_RepairTaskDistributionService:1486714979321", "zhy/t_RepairService:1486621181948","不知道什么原因"));
//		 System.err.println(repairService.updateOrder("zhy/t_RepairService:1486621181948", "er", "laiyuan", "远动"));  
//		 System.err.println (repairService.getBaseInfoByOrderId("zhy/t_RepairService:1486621082656").getData().toString());
//	  System.err.println(repairService.signInOrder("老三", "zhy/t_RepairTaskDistributionService:1486714979321", "zhy/t_RepairService:1486621181948", "19523", "ere", "ere"));
//		   System.err.println(repairService.completeOrder("小", "zhy/t_RrepairTask:1486714979211", "zhy/t_RepairService:1486621181948", "ewr", "er", "era", "rev", 0, "htttp"));	
//		   System.err.println(repairService.delayOrder("小", "zhy/t_RrepairTask:1486714979211", "zhy/t_RepairService:1486621181948", "ewr", "er", "era", "rev", 0, "htttp"));	
		   //				System.err.println( repairTaskDistributionDao.getPeoplesByTaskId("zhy/t_RrepairTask:1486714979211").toString());
		
//	   System.err.println(repairTaskDistributionDao.getDistributionIdByTaskId("zhy/t_RrepairTask:1486714979211").toString());
	   }
}
