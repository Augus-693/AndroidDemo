package fun.augus.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.test
 * @FileName: TimeTest
 * @date 2021年11月11日 20:51
 * @version: 1.0
 */


public class TimeTest {
    public static void main(String[] args){

        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）
    }
}
