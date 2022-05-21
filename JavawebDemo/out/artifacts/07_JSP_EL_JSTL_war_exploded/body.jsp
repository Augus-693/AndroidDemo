<%--
  Created by IntelliJ IDEA.
  User: Augus
  Date: 2021/11/13 0013
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="top.jsp"></jsp:include>--%>
<%@ include file="top.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>主题信息</h3>

    <%
        pageContext.setAttribute("msg","hello");
    %>
    <%=pageContext.getAttribute("msg")%>
</body>
</html>
