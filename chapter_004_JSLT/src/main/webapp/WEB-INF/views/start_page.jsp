<%@ page import="ru.job4j.jslt.crud.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border ='1'>
    <tr>
        <th>Name:</th>
        <th>Login:</th>
        <th>Email:</th>
        <th>Date_creation:</th>
    </tr>
    <c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.name}"></c:out></td>
        <td><c:out value="${user.login}"></c:out></td>
        <td><c:out value="${user.email}"></c:out></td>
        <td><c:out value="${user.createDate}"></c:out></td>
        <td>
            <form action="${pageContext.servletContext.contextPath}/edit" method="get">
                <input type="hidden" name="name" value="${user.name}">
                <input type="hidden" name="login" value="${user.login}">
                <input type="hidden" name="email" value="${user.email}">
                <input type="hidden" name="date" value="${user.createDate}">
                <input type="submit" value="Edit User..">
            </form>
        </td>
        <td>
            <form action="${pageContext.servletContext.contextPath}/delete" method="post">
                <input type="hidden" name="name" value="${user.name}">
                <input type="hidden" name="login" value="${user.login}">
                <input type="hidden" name="email" value="${user.createDate}">
                <input type="submit" value="Delete User">
            </form>

        </td>
    </tr>
    </c:forEach>
</table>
<br/>
<form action="${pageContext.servletContext.contextPath}/add">
    <input type='submit' value='Add new User...'>
</form>
</body>
</html>