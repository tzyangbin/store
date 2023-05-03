package com.tz.store.controller;

import com.tz.store.entity.District;
import com.tz.store.service.IDistrictService;
import com.tz.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取省市区
 *
 * @author yang
 * @version 2023/4/28 23:15
 * @ClassName DistrictController
 * @since jdk11
 */
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{
    @Autowired
    private IDistrictService districtService;
//districts开头的请求都被拦截到getByParent()方法
    @GetMapping({"", "/"})
    //@RequestMapping(method={RequestMethod.GET})
    public JsonResult<List<District>> getByParent(String parent) {
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(OK, data);
    }
}
