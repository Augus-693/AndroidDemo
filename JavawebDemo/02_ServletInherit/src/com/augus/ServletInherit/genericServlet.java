package com.augus.ServletInherit;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.ServletInherit
 * @FileName: genericServlet
 * @date 2021年11月03日 13:41
 * @version: 1.0
 */

@WebServlet("/generic")
public class genericServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet被访问");
    }
}
