package com.augus.servletTest;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.xml.transform.Source;
import javax.xml.ws.ServiceMode;
import java.io.IOException;
import java.sql.SQLOutput;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.servletTest
 * @FileName: servletTest
 * @date 2021年11月03日 13:33
 * @version: 1.0
 */

@WebServlet("/ServletTest")
public class servletTest implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet被创建");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet被访问");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet被销毁");
    }
}
