
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <c:forEach var="user" items="${userList}">
    <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.login}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.data}"/></td>
        <td>
            <form action="user"  >
                <input type="hidden" name="id" value="${user.id}">
                <input type="hidden" name="page" value="update.jsp">
                <button  type="submit" >Edit</button>
            </form>
        </td>
        <td>
            <form action="user" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <input type="hidden" name="action" value="delete">
                <button  type="submit">Delete</button>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
<br>
<a href="user?page=create.jsp">Add New User</a>
</body>
</html>
