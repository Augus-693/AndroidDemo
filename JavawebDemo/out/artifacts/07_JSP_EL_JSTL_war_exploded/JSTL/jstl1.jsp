<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Augus
  Date: 2021/11/14 0014
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
    <%--
    test 必须属性，接受boolean表达式
        如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
        一般情况下，test属性值会结合el表达式一起使用
    --%>
    <c:if test="true">
        <h1>我是真。。。</h1>
    </c:if>
    <br>

    <%
        //判断request域中的一个list集合是否为空，如果不为null则显示遍历集合
        List list = new ArrayList();
        list.add("aaaa");
        request.setAttribute("list",list);
        request.setAttribute("number",3);
    %>

    <c:if test="${not empty list}">
        遍历集合
    </c:if>
    <br>

    <c:if test="${number % 2 != 0}">
        ${number}是奇数
    </c:if>
</body>
</html>
