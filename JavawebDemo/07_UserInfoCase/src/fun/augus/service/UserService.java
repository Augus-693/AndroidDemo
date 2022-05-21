package fun.augus.service;

import fun.augus.doman.PageBean;
import fun.augus.doman.User;

import java.util.List;
import java.util.Map;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.service
 * @FileName: UserServie
 * @date 2021年11月14日 16:31
 * @version: 1.0
 */


public abstract class UserService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> findAll() {
        return null;
    }

    /**
     * 登陆方法
     *
     * @param user
     * @return
     */
    public abstract User login(User user);

    /**
     * //保存User
     *
     * @param user
     */
    public abstract void addUser(User user);

    /**
     * 根据id删除user
     *
     * @param id
     */
    public abstract void deleteUser(String id);

    /**
     * 根据id查询
     * @return
     * @param id
     */
    public abstract User findUserById(String id);

    /**
     * 修改用户
     * @param user
     */
    public abstract void updateUser(User user);

    /**
     * 批量删除用户
     * @param ids
     */
    public abstract void delSelectedUser(String[] ids);

    /**
     * 分页查询,条件查询
     * @param currentPage
     * @param rows
     * @return
     */
    public abstract PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}