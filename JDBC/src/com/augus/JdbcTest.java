package com.augus;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author: Augus
 * @progect: JDBC
 * @package: com.augus
 * @FileName: JdbcTest
 * @date 2021年11月05日 11:57
 * @version: 1.0
 */


public class JdbcTest {

    @Test
    public void JdbcTest() throws Exception {

            //提供三个参数基本信息
            String url = "jdbc:mysql://localhost:3306/login";
            String user = "root";
            String password = "000000";

            //1.加载Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
