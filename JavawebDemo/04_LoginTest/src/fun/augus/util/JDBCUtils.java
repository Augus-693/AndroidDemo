package fun.augus.util;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.util
 * @FileName: JDBCUtils
 * @date 2021年11月04日 20:45
 * @version: 1.0
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类，使用Durid连接池
 */
public class JDBCUtils {

    private static DruidDataSource ds;

    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            //使用ClassLoader加载配置文件，获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.初始化连接池对象
            //DataSource ds = DruidDataSourceFactory.createDataSource(pro);
             ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
