package com.tz.store.service.impl;

import com.tz.store.entity.District;
import com.tz.store.mapper.DistrictMapper;
import com.tz.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理省/市/区数据的业务层实现类
 *
 * @author yang
 * @version 2023/4/28 22:52
 * @ClassName DistrictServiceImpl
 * @since jdk11
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
    //依赖于Mapper层设计
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> list=districtMapper.findByParent(parent);
        //在进行网络数据传输时,为了尽量避免无数据的传递,可以将无效数据设置为null,可以节省流量,提升了效率
        for (District district : list) {
            district.setId(null);
            district.setParent(null);
        }
        return list;
    }

    @Override
    public String getNameByCode(String code) {
        String district= districtMapper.findNameByCode(code);
        return district;
    }
}
