package com.tz.store.controller;

import com.tz.store.entity.Product;
import com.tz.store.service.IProductService;
import com.tz.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * 显示打药信息控制层
 *
 * @author yang
 * @version 2023/5/3 15:20
 * @ClassName ProductController
 * @since jdk11
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList() {
        //list集合
        List<Product> data = productService.findHotList();
//        System.out.println(data);
//        数据转换为json数据,放入data里
        return new JsonResult<List<Product>>(OK, data);

    }

    /**
     * 有返回值
     * @param id
     * @return data 数据
     */
    @GetMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id) {
        // 调用业务对象执行获取数据
        Product data = productService.findById(id);
        // 返回成功和数据
        return new JsonResult<Product>(OK, data);
    }
}
