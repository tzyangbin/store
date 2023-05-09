package com.tz.store.service;

import com.tz.store.entity.Take;
import java.util.List;

/**
 * @author yang
 * @version 2023/5/3 14:57
 * @ClassName ItakeService
 * @since jdk11
 */
public interface ITakeService {
    /**
     * 查询所有信息前20条
     * @return
     */

    List<Take> findTakeList();

    /**
     * 查询
     * @param did
     * @return
     */
    List<Take>  findTakeByList(Integer did);
}
