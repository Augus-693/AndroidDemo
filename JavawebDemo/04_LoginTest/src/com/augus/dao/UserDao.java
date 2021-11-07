package com.augus.dao;

import com.augus.domain.User;
import com.augus.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.dao
 * @FileName: UserDao
 * @date 2021年11月04日 20:40
 * @version: 1.0
 */



/**
 * 操作数据库中User表的类
 */
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate Template = new JdbcTemplate(JDBCUtils.getDataSource());

    /***
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return  user包含用户全部数据,没有查询到，返回null
     */
    public User login(User loginUser){
        try {
            //1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2.调用query方法
            User user = Template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }
    }
}
