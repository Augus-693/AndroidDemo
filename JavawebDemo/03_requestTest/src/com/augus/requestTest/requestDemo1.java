package com.augus.requestTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class requestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        1.获取请求方式：GAT
​			String	getMethod()
​		2.获取虚拟目录：/ServletInherit
​			String	getContextPath()
​		3.获取Servelt路径：/http
​			String	getServletPath()
​		4.获取GAT方式请求参数：username=zhangsan
​			String	getQueryString()
​		5.获取请求URI：/ServletInherit/http
​			String	getRequestURI()
​			String	getRequestURL()
​		6.获取协议及版本号：HTTP/1.1
​			String	getProtocol()
​		7.获取客户机的IP地址:
​			String	getRemoteAddr()
        */
        //1.获取请求方式：GAT
        String method = request.getMethod();
        System.out.println(method);
        //2.获取虚拟目录：/ServletInherit
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3.获取Servlet路径：/http
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4.获取GAT方式请求参数：username=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5.获取请求URI：/ServletInherit/http
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        //6.获取协议及版本号：HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7.获取客户机的IP地址:
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
