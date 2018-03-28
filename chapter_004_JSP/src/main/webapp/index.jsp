<%@ page import="java.sql.ResultSet" %>
<%@ page import="ru.job4j.jsp.crud.UserStore" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
    <%
        ResultSet rs = UserStore.getInstance().allUsers();
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String login = rs.getString("login");
                String email = rs.getString("email");
                String date = rs.getString("date_creation");
    %>
    <tr>
        <td><%=name%></td>
        <td><%=login%></td>
        <td><%=email%></td>
        <td><%=date%></td>
        <td>
            <form action="<%=request.getContextPath()%>/edit" method="get">
                <input type="hidden" name="name" value="<%=name%>">
                <input type="hidden" name="login" value="<%=login%>">
                <input type="hidden" name="email" value="<%=email%>">
                <input type="hidden" name="date" value="<%=date%>">
                <input type="submit" value="Edit User..">
            </form>
        </td>
        <td>
            <form action="<%=request.getContextPath()%>/delete" method="post">
                <input type="hidden" name="name" value="<%=name%>">
                <input type="hidden" name="login" value="<%=login%>">
                <input type="hidden" name="email" value="<%=email%>">
                <input type="submit" value="Delete User">
            </form>

        </td>
    </tr>

    <%
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
</table>
<br/>
<form action="<%=request.getContextPath()%>/pages/add.jsp">
    <input type='submit' value='Add new User...'>
</form>
</body>
</html>