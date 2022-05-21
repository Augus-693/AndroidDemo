package fun.augus.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.listener
 * @FileName: ContextLoaderListener
 * @date 2021年11月25日 13:56
 * @version: 1.0
 */

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    /**
     * 监听ServletContext对象创建的，ServletContext对象服务器启动后自动创建
     * 在服务器启动后自动创建
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被创建");
    }

    /**
     * 服务器关闭后，ServletContext对象被销毁，当服务器正常关闭后该方法被调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁");
    }
}
