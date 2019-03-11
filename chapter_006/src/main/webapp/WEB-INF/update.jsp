<%@ page import="ru.job4j.servlets.User" %>
<%@ page import="ru.job4j.servlets.MemoryDataStore" %>
<%@ page import="ru.job4j.servlets.DbStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = DbStore.getInstance().findById(Integer.parseInt(request.getParameter("id")));
%>
<h3>Input user data</h3>
<div style="padding: 15px 5px">
    <form action="user" method="post">
        <table>
            <tr>
                <td></td>
                <td><input type="hidden" name="id" value=<%=user.getId()%>>
                </td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value= <%=user.getName()%>>
                </td>
            </tr>
            <tr>
                <td>Login:</td>
                <td><input type="text" name="login" value= <%=user.getLogin()%>>
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" value=<%=user.getEmail()%>>
                </td>
            </tr>
            <tr>
                <td colspan='2'><input type='submit' value='Edit & Save'/>
                </td>
            </tr>
        </table>
        <input type="hidden" name="action" value="update">
    </form>
</div>
</body>
</html>
