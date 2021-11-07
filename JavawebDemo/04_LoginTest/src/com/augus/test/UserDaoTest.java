package com.augus.test;


import com.augus.dao.UserDao;
import com.augus.domain.User;
import org.junit.Test;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.test
 * @FileName: UserDaoTest
 * @date 2021年11月04日 21:21
 * @version: 1.0
 */


public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("super");
        loginUser.setPassword("123123");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }

}
