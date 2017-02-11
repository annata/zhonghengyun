package com.ioe.zhy.controller.project;

import com.ioe.zhy.entity.Project;
import com.ioe.zhy.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangqiyun on 2017/1/18.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Resource
    ProjectService projectService;

    @RequestMapping("/add")
    @ResponseBody
    public Map add(Project project){
       
        Map<String ,Object> result=new HashMap<>();
      
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map update(Project project){
    	Map<String ,Object> result=new HashMap<>();
      
        return result;
    }

    @RequestMapping("/get")
    @ResponseBody
    public Map get(String companyId,Integer status,int pageSize,int pageIndex){
        Map<String ,Object> result=new HashMap<>();
        result.put("code","0");
        result.put("data",projectService.getProjectRecordList(companyId, status, pageSize, pageIndex));
        return result;
    }
}
