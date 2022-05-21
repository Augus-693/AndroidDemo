package fun.augus.test;

import fun.augus.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.test
 * @FileName: BeanUtilsTest
 * @date 2021年11月07日 14:22
 * @version: 1.0
 */


public class BeanUtilsTest {

    @Test
    public void test() {

        User user = new User();
        try {
            BeanUtils.setProperty(user,"username","zhangsan");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);

        try {
            BeanUtils.getProperty(user, "username");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
