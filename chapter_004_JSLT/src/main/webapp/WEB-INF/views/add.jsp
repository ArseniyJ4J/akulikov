<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/add" method='post'>
    <p>Enter parameters of new User:</p>
    <p>Name : <input required maxlength='20' type='text' name='name'></p>
    <p>Login : <input required maxlength='15' type='text' name='login'></p>
    <p>Email : <input required maxlength='30' type='text' name='email'></p>
    <p><input type='submit' value='Add new User'></p>
</form>

</body>
</html>
