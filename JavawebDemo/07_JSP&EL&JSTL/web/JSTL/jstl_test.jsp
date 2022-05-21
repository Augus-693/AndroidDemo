<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="fun.augus.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Augus
  Date: 2021/11/14 0014
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add(new User("张三",23,new Date()));
        list.add(new User("李四",25,new Date()));
        list.add(new User("王五",18,new Date()));
        request.setAttribute("list",list);
    %>

    <table border="1" width="500" align="center">
        <tr bgcolor="#4d3542">
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>
        <%-- 数据行 --%>
        <c:forEach items="${list}" var="user" varStatus="s">

            <c:if test="${s.count % 2 == 0}">   <%--偶数--%>
                <tr bgcolor="#a52a2a">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.bitStr}</td>
                </tr>
            </c:if>
            <c:if test="${s.count % 2 != 0}">   <%--奇数--%>
                <tr bgcolor="#8a2be2">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.bitStr}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</body>
</html>
