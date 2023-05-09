package com.tz.store.mapper;


import com.tz.store.entity.Take;

import java.util.List;


/**
 * 打药场景模块的持久层接口
 *
 * @author tzyangbin
 * @version 2023/5/2 23:04
 * @since jdk11
 */
public interface TakeMapper {

    /**
     * 查询所有信息前20名
     *
     * @return 热销商品前四名的集合
     */
    List<Take> findTakeList();

    /**
     * 查询
     * @param did
     * @return
     */
    List<Take> findTakeByList(Integer did);
}
