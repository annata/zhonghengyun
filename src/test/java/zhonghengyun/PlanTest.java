/**
 * 
 */
package zhonghengyun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ioe.zhy.dao.WatchRecordDao;
import com.ioe.zhy.service.WatchManageService;

/**
 * @author hq
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class PlanTest {
	
	   @Resource
	   private  WatchManageService  watchManageService;
	   
	   
	   @Resource
	   private  WatchRecordDao  watchRecordDao;
	   @Test
	   public void test1() throws InterruptedException{
		   
		   
//		   watchManageService.addWatchPlan("124", System.currentTimeMillis(), System.currentTimeMillis()+1000*3600,"一,二,三,四,五,六", "1,2,3,4,5,6", true);
//	  System.err.println(watchRecordDao.getWatchRecordByPlanId("zhy/t_WatchManageService:1487060475274").toString());
//	  System.err.println(watchRecordDao.getWatchersByPlanId("zhy/t_WatchManageService:1487060475274").toString());
//		   Map<String, Object> map=new HashMap<>();
//		   map.put("plan_id", "zhy/t_WatchManageService:1487125878358");
//		   List<String> list=new ArrayList<>();
//		   list.add("3");
//		   list.add("2");
//		   map.put("list", list);
//		   System.err.println(watchRecordDao.deleteWatchRecordList(map));
//		   watchManageService.updateWatchPlan("zhy/t_WatchManageService:1487127473530", "134", 1487060474847L, 1487060474848L, "三,四,七", "3,4,7", false);
		   
//		   watchManageService.deleteWatchPlan("zhy/t_WatchManageService:1487127473530");
//		   watchManageService.beginWatch("zhy/t_WatchManageService:1487127473530", "6");
//		   watchManageService.completeWatch("zhy/t_WatchManageService:1487127473530", "6", "tt");
//		  System.err.println(watchManageService.getWatchPlan("6", true, 1, 5).getDataList().toString());
//		   System.err.println(watchManageService.getHistoryWatchPlan("6", true, 1487137468154L, 1487137468154L, 1, 10));
//		   System.err.println(watchManageService.getWatchRecordByPlanId("zhy/t_WatchManageService:1487127473530").getData());
	   
	   }

	   
}
