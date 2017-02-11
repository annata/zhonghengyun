package com.ioe.zhy.serviceImpl;

import com.ioe.common.util.Constants;
import com.ioe.common.util.ZRIGenerater;
import com.ioe.zhy.dao.ProjectDao;
import com.ioe.zhy.entity.Project;
import com.ioe.zhy.service.ProjectService;
import com.ioe.zhy.util.ListResult;
import com.ioe.zhy.util.PageResult;
import com.ioe.zhy.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by wangqiyun on 2017/1/18.
 */
@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {
	private static final String SERVICE_NAME = "zhy/t_ProjectService";
	@Resource
	private ProjectDao projectDao;

	@Override
	public Result saveProjectRecord(String result,Integer status, String powerClientId, String powerClientName,
			String electricianId, String electricianName, String serviceCompanyId) {
		Result result1 = new Result();

		try {
			Project project = new Project();
			project.setRecord_id(ZRIGenerater.generate(SERVICE_NAME));
			project.setResult(result);
			project.setStatus(status);
			project.setSave_time(System.currentTimeMillis());
			project.setPowerClient_id(powerClientId);
			project.setPowerClient_name(powerClientName);
			project.setElectrician_id(electricianId);
			project.setElectrician_name(electricianName);
			project.setService_company_id(serviceCompanyId);
			project.setSys_hash("1");
			if (projectDao.addProject(project)) {
				result1.setMessage("success");
				return result1;
			}
		} catch (Exception e) {

			result1.setCode(Constants.SERVICE_ERROR);
			result1.setMessage("error");
		}
		return result1;
	}

	@Override
	public Result updateProjectRecord(String recordId, String result, Integer status) {
		Result result1 = new Result();

		try {
			Project project = new Project();
			project.setRecord_id(recordId);
			project.setSys_hash("1");
			project.setResult(result);
			project.setStatus(status);

			if (projectDao.updateProject(project)) {
				result1.setMessage("success");
				return result1;
			}
		} catch (Exception e) {

			result1.setCode(Constants.SERVICE_ERROR);
			result1.setMessage("error");
		}
		return result1;

	}

	@Override
	public ListResult<Project> getProjectRecord(String recordId) {
		ListResult<Project> result = new ListResult<>();
		try {
		List<Project> list=	projectDao.getProjectById(recordId);
			result.setDataList(list);
		} catch (Exception e) {

			result.setCode(Constants.SERVICE_ERROR);
			result.setMessage("error");
		}
		return result;
	}

	@Override
	public PageResult<Project> getProjectRecordList(String companyId, Integer status, int pageSize, int pageIndex) {
		PageResult<Project> pageResult = new PageResult<>();

		try {
			int startNumber=(pageIndex-1)*pageSize;
			pageResult.setLength(pageSize);
			pageResult.setStart(pageIndex);
			pageResult.setDataList(projectDao.getProjectRecordList(status, companyId, startNumber, pageSize));
			pageResult.setTotalCount(projectDao.getProjectCount(status, companyId));
			pageResult.setMessage("success");
		} catch (Exception e) {
			
			pageResult.setCode(Constants.SERVICE_ERROR);
			pageResult.setMessage("error");
		}

		return pageResult;

	}

}
