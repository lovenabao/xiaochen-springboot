package com.xiaochen.springboot.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author shkstart
 * @create 04-01 11:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidTets {
    @Resource
    DataSource dataSource;

    @Test
    public void test()throws Exception{
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        Connection connection = dataSource.getConnection();

        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());
        connection.close();
    }
}
