<%@ page import="ru.job4j.servlets.User" %>
<%@ page import="java.util.Collection" %>
<%@ page import="ru.job4j.servlets.ValidateService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>login</th>
        <th>Email</th>
        <th>Data</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <%
        Collection<User> users = ValidateService.INSTANCE.findAll();
        if (users != null) {
            for (User user : users) {
    %>
    <tr>
        <td><%= user.getId()%>
        </td>
        <td><%= user.getName()%>
        </td>
        <td><%= user.getLogin()%>
        </td>
        <td><%= user.getEmail()%>
        </td>
        <td><%= user.getData()%>
        </td>
        <td>
            <form action = <%=request.getContextPath()%>"/update.jsp" method=get>
                <input type="hidden" name="id" value=<%=user.getId()%>>
                <button name="id" type="submit">Edit</button>
            </form>
        </td>
        <td>
            <form action=<%=request.getContextPath()%>"/user" method="post">
                <input type="hidden" name="id" value=<%=user.getId()%>>
                <input type="hidden" name="action" value="delete">
                <button name="id" type="submit">Delete</button>
            </form>
        </td>
    </tr>

    <%
            }
        }
    %>
</table>
<br>
<a href=<%=request.getContextPath()%>"/create.jsp">Add New User</a>
</body>
</html>
