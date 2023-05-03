package com.tz.store.service;

import com.tz.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yang
 * @version 2023/4/28 23:08
 * @ClassName DistrictServiceTests
 * @since jdk11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTests {
    @Autowired
    private IDistrictService districtService;

    @Test
    public void getByParent(){
        //86表示中国,所有省的父代号都是86
        String parent = "86";
        //list集合接受
        List<District> list=districtService.getByParent(parent);
        for (District district:list){
            System.out.println(district);
        }
    }
    @Test
    public void getNameByCode() {
            String code = "430000";
            String result = districtService.getNameByCode(code);
            System.out.println(result);
    }

}
