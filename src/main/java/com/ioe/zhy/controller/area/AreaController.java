package com.ioe.zhy.controller.area;

import com.ioe.zhy.entity.Area;
import com.ioe.zhy.service.AreaService;
import com.ioe.zhy.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangqiyun on 2017/1/19.
 */
@Controller
@RequestMapping("/area")
public class AreaController {
    @Resource
    AreaService areaService;

    @RequestMapping("/add")
    @ResponseBody
    public Map add(Area area) {
        Result result1 = areaService.addArea(area.getCompany_id(), area.getArea_name());
        Map<String, Object> result = new HashMap<>();
        result.put("code", result1);
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map update(Area area) {
        Result result1 = areaService.updateArea(area.getArea_id(), area.getArea_name());
        Map<String, Object> result = new HashMap<>();
        result.put("code", result1);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Area area) {
        Result result1 = areaService.deleteArea(area.getArea_id());
        Map<String, Object> result = new HashMap<>();
        result.put("code", result1);
        return result;
    }

    @RequestMapping("/get")
    @ResponseBody
    public Map get(Area area) {
        Result result1 = areaService.getAreaByCompanyId(area.getCompany_id());
        Map<String, Object> result = new HashMap<>();
        result.put("code", result1);
        return result;
    }

    @RequestMapping("/bindElectricianAndArea")
    @ResponseBody
    public Map bindElectricianAndArea(String electricianId, String areaId) {
        Result result1 = areaService.bindElectricianAndArea(electricianId, areaId);
        Map<String, Object> result = new HashMap<>();
        result.put("code", result1);
        return result;
    }

    @RequestMapping("/unBindElectricianAndArea")
    @ResponseBody
    public Map unBindElectricianAndArea(String electricianId, String areaId) {
        Result result1 = areaService.unBindElectricianAndArea(electricianId, areaId);
        Map<String, Object> result = new HashMap<>();
        result.put("code", result1);
        return result;
    }

    @RequestMapping("/bindPowerClientAndArea")
    @ResponseBody
    public Map bindPowerClientAndArea(String powerClientId, String areaId) {
        Result result1 = areaService.bindPowerClientAndArea(powerClientId, areaId);
        Map<String, Object> result = new HashMap<>();
        result.put("code", result1);
        return result;
    }

    @RequestMapping("/unBindPowerClientAndArea")
    @ResponseBody
    public Map unBindPowerClientAndArea(String powerClientId, String areaId) {
        Result result1 = areaService.unBindPowerClientAndArea(powerClientId, areaId);
        Map<String, Object> result = new HashMap<>();
        result.put("code", result1);
        return result;
    }
}
