package com.tz.store.service;

import com.tz.store.entity.Take;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yang
 * @version 2023/5/3 15:14
 * @ClassName TakeServiceTests
 * @since jdk11
 */
//SpringBootTest表示标注当前的类是一测试类，不会被打包
@SpringBootTest
//RunWith：表示启动这个单元测试类，需要传递一个参数，SpringRunner.class实例类型
@RunWith(SpringRunner.class)
public class TakeServiceTests {

    @Autowired
    private ITakeService takeService;

    @Test
    public void findTakeList() {
        List<Take> list = takeService.findTakeList();
        System.out.println("count=" + list.size());
        for (Take item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void findTakeByid() {
        Integer did=66;
        List<Take> list = takeService.findTakeByList(did);
        System.out.println(list);

    }

}