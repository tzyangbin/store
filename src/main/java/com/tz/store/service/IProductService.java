package com.tz.store.service;

import com.tz.store.entity.Product;
import java.util.List;

/**
 * 处理商品数据的业务层接口
 * @author yang
 * 商品数据不存在的异常
 * @version 2023/4/27 22:17
 * @ClassName IProductService
 * @since jdk11
 */
public interface IProductService {
    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详情
     * @param id 商品id
     * @return 匹配的商品详情，如果没有匹配的数据则返回null
     */
    Product findById(Integer id);
}
