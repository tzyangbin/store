package com.tz.store.mapper;

import com.tz.store.entity.Address;
import com.tz.store.entity.Take;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author yang
 * @version 2023/5/2 23:12
 * @ClassName TakeMapperTest
 * @since jdk11
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TakeMapperTests {

    @Autowired
    private TakeMapper takeMapper;

    @Test
    public void findByAllTest(){
        Integer status = 1;
        List<Take> list = takeMapper.findByStatus(status);
        System.out.println("count=" + list.size());
        for (Take item : list) {
            System.out.println(item);
        }
    }

}
