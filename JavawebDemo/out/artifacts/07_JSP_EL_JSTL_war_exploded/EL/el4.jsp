<%--
  Created by IntelliJ IDEA.
  User: Augus
  Date: 2021/11/14 0014
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el隐式对象</title>
</head>
<body>
    ${pageContext.request}<br>
    <h4>在jsp页面动态获取虚拟目录</h4>
    ${pageContext.request.contextPath}
</body>
</html>
