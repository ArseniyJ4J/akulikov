<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}">
    <p>User with parameters:</p>
    <p>Name : <c:out value="${param.name}"/> </p>
    <p>Login : <c:out value="${param.login}"/> </p>
    <p>Email : <c:out value="${param.email}"/> </p>
    <p style="color:forestgreen">Sucsessfully Edited!</p>
    <p><input type='submit' value='To Main Menu...'></p>
</form>
</body>
</html>
