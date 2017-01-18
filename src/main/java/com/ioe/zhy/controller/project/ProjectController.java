package com.ioe.zhy.controller.project;

import com.ioe.zhy.entity.Project;
import com.ioe.zhy.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public Map add(Project project){
        projectService.saveProjectRecord(project.getCategory(),project.getContent(),project.getResult(),project.isStatus(),project.getPowerClient_id(),project.getElectrician_id(),project.getService_company_id());
        Map<String ,Object> result=new HashMap<>();
        result.put("code","0");
        return result;
    }
}
