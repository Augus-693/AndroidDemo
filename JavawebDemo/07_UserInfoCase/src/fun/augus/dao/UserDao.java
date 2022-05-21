package fun.augus.dao;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.dao
 * @FileName: UserDao
 * @date 2021年11月14日 16:36
 * @version: 1.0
 */

import fun.augus.doman.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的Dao
 */
public abstract class UserDao {
    //使用JDBC操作数据库
    public List<User> findAll() {
        return null;
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        return null;
    }

    public abstract void add(User user);

    public abstract void delete(int parseInt);

    public abstract User findById(int id);

    public abstract void update(User user);

    public abstract int findTotalCount(Map<String, String[]> condition);

    public abstract List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
