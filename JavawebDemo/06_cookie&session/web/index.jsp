<%--
  Created by IntelliJ IDEA.
  User: Augus
  Date: 2021/11/10 0010
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>hi JSP</h1>

    <%
      //response缓冲区数据先执行，无论定义在哪都最先执行
      response.getWriter().write("response");
    %>
    <%
      System.out.println("Hello JSP");

      //获取虚拟目录
      String contextPath = request.getContextPath();
      out.print(contextPath);
    %>

    <%!
      int i = 1;
    %>

    <%= i %>

  </body>
</html>
