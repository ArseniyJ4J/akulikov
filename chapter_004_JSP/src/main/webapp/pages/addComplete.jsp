<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>">
    <p>User with parameters:</p>
    <p>Name : <%=request.getParameter("name")%> </p>
    <p>Login : <%=request.getParameter("login")%> </p>
    <p>Email : <%=request.getParameter("email")%> </p>
    <p style="color:green">Sucsessfully Add!</p>
    <p><input type='submit' value='To Main Menu...'></p>
</form>
</body>
</html>
