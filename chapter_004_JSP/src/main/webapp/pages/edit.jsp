<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/edit" method="post">
    <p>Edit User's parameters:</p>
    <p>Name : <input required maxlength='20' type='text' name='name' value='<%=request.getParameter("name")%>'></p>
    <p>Login : <input required maxlength='15' type='text' name='login' value='<%=request.getParameter("login")%>'></p>
    <p>Email : <input required maxlength='30' type='text' name='email' value='<%=request.getParameter("email")%>'></p>
    <input type='hidden' name='oldLogin' value='<%=request.getParameter("name")%>'>
    <p><input type='submit' value='Edit'></p>
</form>
</body>
</html>
