package com.tz.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    @Autowired //自动装配
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    /**
     * 数据库连接测试,数据库连接池,1.dbcp 2.c3p0 3.hikari 数据库连接池 4.druid
     */
    @Test
    void getConnection() throws SQLException {
        System.out.println("数据库连接" + dataSource.getConnection());
    }

}
