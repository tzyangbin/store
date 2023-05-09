package com.tz.store.service;

import com.tz.store.entity.Product;
import com.tz.store.entity.TakeDt;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yang
 * @version 2023/5/4 18:31
 * @ClassName TakeDtServiceTests
 * @since jdk11
 */

//SpringBootTest表示标注当前的类是一测试类，不会被打包
@SpringBootTest
//RunWith：表示启动这个单元测试类，需要传递一个参数，SpringRunner.class实例类型
@RunWith(SpringRunner.class)
public class TakeDtServiceTests {

    @Autowired
    private ITakeDtService iTakeDtService;

    @Test
    public void findTakeDtDid() {
        Integer did=2;
        List<TakeDt> list= iTakeDtService.findTakeDtDid(did);
        for (TakeDt item : list) {
            System.out.println(item);
        }
    }

}
