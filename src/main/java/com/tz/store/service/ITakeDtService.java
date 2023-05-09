package com.tz.store.service;

import com.tz.store.entity.Take;
import com.tz.store.entity.TakeDt;

import java.util.List;

/**
 * 打药详情
 *
 * @author tzyangbin
 * @version 2023/5/4 18:09
 * @since jdk11
 */
public interface ITakeDtService {
    /**
     * 查询所有信息前20条
     * @param did
     * @return 匹配的商品详情，如果没有匹配的数据则返回null
     */
    List<TakeDt> findTakeDtDid(Integer did);
}
