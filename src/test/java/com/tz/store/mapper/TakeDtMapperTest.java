package com.tz.store.mapper;


import com.tz.store.entity.TakeDt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yang
 * @version 2023/5/3 11:45
 * @ClassName TakeDtMapperTest
 * @since jdk11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TakeDtMapperTest {

    @Autowired
    private TakeDtMapper takeDtMapper;

    @Test
    public void findByDidTest(){

        List<TakeDt> list = takeDtMapper.findByDid(66);
        System.out.println("count=" + list.size());
        for (TakeDt item : list) {
            System.out.println(item);
        }
    }


}
