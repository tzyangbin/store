package com.tz.store.controller;



import com.tz.store.entity.Take;

import com.tz.store.service.ITakeService;
import com.tz.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


/**
 * 查询所有打药信息
 *
 * @author yang
 * @version 2023/5/3 22:36
 * @ClassName TakeController
 * @since jdk11
 */
@RestController
@RequestMapping("take")
public class TakeController extends BaseController{
    @Autowired
    private ITakeService takeService;

    @RequestMapping("take_list")
    public JsonResult<List<Take>> findTakeList(Integer id) {
        List<Take> data = takeService.findTakeList();
        return new JsonResult<List<Take>>(OK, data);
    }



}
