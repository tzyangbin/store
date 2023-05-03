package com.tz.store.mapper;

import com.tz.store.entity.District;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yang
 * @version 2023/4/28 22:34
 * @ClassName DistrictMapperTests
 * @since jdk11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictMapperTests {
    @Autowired
    private DistrictMapper districtMapper;
    @Test
    public void findByParent() {
        String parent = "110100";
        List<District> list = districtMapper.findByParent(parent);
        System.out.println("count=" + list.size());
        for (District district : list) {
            System.out.println(district);
        }
    }

    @Test
    public void findNameByCode() {
        String code = "540000";
        String name = districtMapper.findNameByCode(code);
        System.out.println(name);
    }
    @Test
    public void findByNameCode(){
        String name=districtMapper.findNameByCode("610000");
        System.out.println(name);
    }

}
