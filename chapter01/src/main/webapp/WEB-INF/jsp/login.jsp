<%--
  Created by IntelliJ IDEA.
  User: bing.wei
  Date: 2014/12/23
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>景区网站登录</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="red"><c:out value="${error}"/></font>
    </c:if>
    <form action="<c:url value="/admin/loginCheck.html"/>" method="post">
        用户名：
        <input type="text" name="userName">
        <br/>
        密码：
        <input type="password" name="password">
        <br>
        <input type="submit" value="Login"/>
        <input type="reset" value="reset"/>
    </form>
</body>
</html>
