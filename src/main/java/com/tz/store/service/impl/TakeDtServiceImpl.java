package com.tz.store.service.impl;

import com.tz.store.entity.TakeDt;
import com.tz.store.mapper.TakeDtMapper;
import com.tz.store.service.ITakeDtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 打药详细信息方法
 *
 * @author yang
 * @version 2023/5/4 18:13
 * @ClassName TakeDtServiceImpl
 * @since jdk11
 */
@Service
public class TakeDtServiceImpl implements ITakeDtService {
    @Autowired
    private TakeDtMapper takeDtMapper;

    @Override
    public List<TakeDt> findTakeDtDid(Integer did) {
        List<TakeDt> list = takeDtMapper.findByDid(did);
        for (TakeDt takeDt : list) {
            takeDt.setStatus(null);
            takeDt.setCreatedUser(null);
            takeDt.setCreatedTime(null);
            takeDt.setModifiedUser(null);
            takeDt.setModifiedTime(null);
        }
        return list;
    }
}
