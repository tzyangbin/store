package com.tz.store.service.impl;

import com.tz.store.entity.Take;
import com.tz.store.mapper.TakeMapper;
import com.tz.store.service.ITakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang
 * @version 2023/5/3 15:09
 * @ClassName TakeServiceImpl
 * @since jdk11
 */
@Service //@service注解:将当前类的对象交给spring来管理,自动创建对象来维护
public class TakeServiceImpl implements ITakeService {

    //调用TakeMapper层,并装配,可以调用addressMapper方法
    @Autowired
    private TakeMapper takeMapper;


    @Override
    public List<Take> findTakeList() {
        List<Take> list = takeMapper.findTakeList();
        for (Take take : list) {
            take.setStatus(null);
            take.setCreatedUser(null);
            take.setCreatedTime(null);
            take.setModifiedUser(null);
            take.setModifiedTime(null);
        }
        return list;
    }

    @Override
    public List<Take>  findTakeByList(Integer did) {
        List<Take> list = takeMapper.findTakeByList(did);
        for (Take take : list) {
            take.setStatus(null);
            take.setCreatedUser(null);
            take.setCreatedTime(null);
            take.setModifiedUser(null);
            take.setModifiedTime(null);
        }
        return list;
    }
}
