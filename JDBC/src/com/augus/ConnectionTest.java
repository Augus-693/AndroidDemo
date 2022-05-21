package com.augus;

import org.junit.Test;

import java.io.InputStream;
import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author: Augus
 * @progect: JDBC
 * @package: com.augus
 * @FileName: ConnectionTest
 * @date 2021年11月05日 11:22
 * @version: 1.0
 */


public class ConnectionTest {
    //方式五：将数据库连接需要的四个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接

    /*
     * 此种方式的好处
     * 1.实现了代码与数据的分离，实现了解耦
     * 2.如果需要修改配置文件信息，可以避免程序重新打包。
     */

    @Test
    public void testConnection() throws Exception {

        //1.读取配置文件中的四个基本信息、
        //InputStream is = ConnectIOException.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream is = ConnectIOException.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String username = pros.getProperty("username");
        String password = pros.getProperty("password");
        String  url = pros.getProperty("url");
        String driveClassName = pros.getProperty("driverClassName");

        //2.加载驱动
        Class.forName(driveClassName);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println(conn);
    }

}
