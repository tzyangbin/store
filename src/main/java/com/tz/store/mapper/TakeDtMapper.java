package com.tz.store.mapper;

import com.tz.store.entity.Address;
import com.tz.store.entity.Take;
import com.tz.store.entity.TakeDt;

import java.util.List;

/**
 * @author tzyangbin
 * @version 2023/5/3 11:36
 * @since jdk11
 */
public interface TakeDtMapper {
    /**
     * 根据did显示所有打药信息
     * @param did
     * @return
     */

    List<TakeDt> findByDid(Integer did);

}
