package com.tz.store.controller;

import com.tz.store.entity.Take;
import com.tz.store.entity.TakeDt;
import com.tz.store.service.ITakeDtService;
import com.tz.store.service.ITakeService;
import com.tz.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 打药详情
 *
 * @author yang
 * @version 2023/5/4 21:37
 * @ClassName TakeDtController
 * @since jdk11
 */
@RestController
@RequestMapping("takeDt")
public class TakeDtController extends BaseController{
    @Autowired
    private ITakeDtService iTakeDtService;

    @Autowired
    private ITakeService takeService;

    @RequestMapping("{did}/list")
    public JsonResult<List<TakeDt>>findTakeDtDid(@PathVariable("did") Integer did) {

        List<TakeDt> data = iTakeDtService.findTakeDtDid(did);
        return new JsonResult<List<TakeDt>>(OK, data);
    }

    @RequestMapping("{did}/take")
    public JsonResult<List<Take>>findTakeByList(@PathVariable("did") Integer did) {
        List<Take> data = takeService.findTakeByList(did);
        return new JsonResult<List<Take>>(OK,data);
    }

}
