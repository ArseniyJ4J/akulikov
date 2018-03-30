<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}">
    <p>User with parameters:</p>
    <p>Name : <c:out value="${user.name}"/></p>
    <p>Login : <c:out value="${user.login}"/> </p>
    <p>Email : <c:out value="${user.email}"/> </p>
    <%--<p>Email : <c:out value="${email}"></c:out> </p>--%>
    <p style="color:green">Sucsessfully Add!</p>
    <p><input type='submit' value='To Main Menu...'></p>
</form>
</body>
</html>
