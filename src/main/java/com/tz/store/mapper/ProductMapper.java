package com.tz.store.mapper;

import com.tz.store.entity.Product;

import java.util.List;

/**
 * 处理商品数据的持久层接口
 * @author tzyangbin
 * @version 2023/5/2 23:04
 * @since jdk11
 */
public interface ProductMapper {
    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合,有返回值
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详情
     * @param id 商品id
     * @return 匹配的商品详情，如果没有匹配的数据则返回null
     */
    Product findById(Integer id);
}
