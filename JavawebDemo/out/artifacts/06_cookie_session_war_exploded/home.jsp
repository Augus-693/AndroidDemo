<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Augus
  Date: 2021/11/12 0012
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Augus</title>
</head>
<body>
    <%
        //获取所有的Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有cookie为lastTime
        //遍历Cookie数组
        if (cookies != null && cookies.length > 0) {
            for(Cookie cookie : cookies) {
                //获取cookie的名称
                String name = cookie.getName();
                //判断名称是否是：lastTime
                if("lastTime".equals(name)) {
                    //有该Cookie，不是第一次访问

                    flag = true;//有lastTime的cookie
                    //设置Cookie的value
                    //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
                    SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                    sdf.applyPattern("yyyy年MM月dd日HH:mm:ss");
                    Date date = new Date();// 获取当前时间
                    String str_date = sdf.format(date);
                    cookie.setValue(str_date);
                    System.out.println("编码前"+str_date);
                    //URL编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后"+str_date);

                    //设置cookie的存活时间
                    cookie.setMaxAge(60 * 60 * 26 * 30);//一月
                    //cookie.setMaxAge(15);
                    response.addCookie(cookie);

                    //响应数据
                    //获取Cookie的value：时间
                    String value = cookie.getValue();
                    System.out.println("解码前："+str_date);
                    //URL解码
                    value = URLDecoder.decode(value, "UTF-8");
                    System.out.println("解码后："+str_date);
    %>
                    <h1>欢迎回来，您上次登陆的时间为：<%=value%></h1>
    <%
                    break;
                }
            }
        }

        if(cookies == null || cookies.length == 0 || flag    == false) {
            //没有，第一次访问

            //设置Cookie的value
            //获取当前时间的字符串，设置Cookie的值，发送cookie
            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy年MM月dd日HH:mm:ss");
            Date date = new Date();// 获取当前时间
            String str_date = sdf.format(date);
            System.out.println("编码前："+str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后："+str_date);

            Cookie cookie = new Cookie("lastTime",str_date);

            //设置cookie的存活时间
            cookie.setMaxAge(60 * 60 * 26 * 30);
            //cookie.setMaxAge(15);
            response.addCookie(cookie);

    %>
            <h1>您好，欢迎您首次访问</h1>
    <%

        }
    %>
</body>
</html>
