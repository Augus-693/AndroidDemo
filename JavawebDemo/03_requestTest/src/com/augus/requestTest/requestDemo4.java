package com.augus.requestTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

@WebServlet("/requestDemo4")
public class requestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据:referer
        String referer = request.getHeader("referer");
        System.out.println(referer);//http://localhost:8080/03_requestTest/login.html

        //防盗链操作
        if (referer != null){
            if (referer.contains("/03_requestTest")){
                //正常访问
                //System.out.println("正常访问");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("正常访问");
            }else {
                //盗链
                //System.out.println("不是正常访问");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("不是正常访问");
            }
        }
    }
}
