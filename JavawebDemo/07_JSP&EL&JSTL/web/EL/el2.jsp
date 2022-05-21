<%--
  Created by IntelliJ IDEA.
  User: Augus
  Date: 2021/11/13 0013
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取取域中的数据</title>
</head>
<body>
    <%
        //在域中存储数据
        request.setAttribute("name","zhangsan");
        session.setAttribute("age","23");
    %>
    <h3>el获取值</h3>
    ${requestScope.name}
    ${sessionScope.age}
</body>
</html>
