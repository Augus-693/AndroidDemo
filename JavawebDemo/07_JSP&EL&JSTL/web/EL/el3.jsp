<%@ page import="fun.augus.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Augus
  Date: 2021/11/13 0013
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());

        request.setAttribute("u",user);

        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);

        request.setAttribute("list",list);

        Map map = new HashMap();
        map.put("sname","李四");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);
    %>

<h3>el获取对象中的值</h3>
${requestScope.u}<br>

<%--通过对象的属性获取数据--%>
${requestScope.u.name}<br>
${requestScope.u.age}<br>
${requestScope.u.bitStr}<br>

<h3>el获取List的值</h3>
${list}<br>
${list[0]}<br>
${list[1]}<br>
${list[10]}<br><%-- 角标越界显示空字符串 --%>
${list[2].name}

<h3>el获取map的值</h3>
${map.gender}<br>
${map["gender"]}<br>
${map.user.name}<br>
</body>
</html>
