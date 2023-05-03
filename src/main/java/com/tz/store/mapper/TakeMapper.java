package com.tz.store.mapper;


import com.tz.store.entity.Take;

import java.util.List;


/**
 * 打药场景模块的持久层接口
 * @author tzyangbin
 * @version 2023/5/2 23:04
 * @since jdk11
 */
public interface TakeMapper {
    /**
     * 查询所有用户
     * @param status
     * @return
     */
    List<Take> findByStatus(Integer status);
   }
