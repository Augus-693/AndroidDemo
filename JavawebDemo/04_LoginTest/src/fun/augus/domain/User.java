package fun.augus.domain;
/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.loginTest
 * @FileName: User
 * @date 2021年11月04日 20:34
 * @version: 1.0
 */

/**
 * 用户的实体类
 */
public class User {

    private int id;
    private String username;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
