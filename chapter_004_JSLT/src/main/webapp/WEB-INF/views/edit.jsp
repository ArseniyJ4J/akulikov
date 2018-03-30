<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/edit" method="post">
    <p>Edit User's parameters:</p>
    <p>Name : <input required maxlength='20' type='text' name='name' value="${param.name}"></p>
    <p>Login : <input required maxlength='15' type='text' name='login' value="${param.login}"></p>
    <p>Email : <input required maxlength='30' type='text' name='email' value="${param.email}"></p>
    <input type='hidden' name='oldLogin' value="${param.name}">
    <p><input type='submit' value='Edit'></p>
</form>
</body>
</html>
