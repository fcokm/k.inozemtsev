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
        <th>Role</th>
        <th>Edit</th>
        <th>Delete</th>
        <c:forEach var="user" items="${userList}">

    <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.login}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.data}"/></td>
        <td><c:out value="${user.role}"/></td>
        <td>
            <form action="user"  >
                <input type="hidden" name="id" value="${user.id}">
                <input type="hidden" name="page" value="update.jsp">
                <c:choose>
                    <c:when test="${sessionScope.access != 'denied'}">
                        <button   type="submit">Edit</button>
                    </c:when>
                    <c:when test="${sessionScope.id eq user.id }">
                        <button  type="submit">Edit</button>
                    </c:when>
                    <c:otherwise>
                        <button  disabled type="submit">Edit</button>
                    </c:otherwise>
                </c:choose>
            </form>
        </td>
        <td>
            <form  action="user" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <input type="hidden" name="action" value="delete">
                <c:choose>
                    <c:when test="${sessionScope.access != 'denied'}">
                        <button  type="submit">Delete</button>
                    </c:when>
                    <c:otherwise>
                        <button  disabled type="submit">Delete</button>
                    </c:otherwise>
                </c:choose>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
<br>
<c:if test="${sessionScope.access != 'denied'}">
    <a href="user?page=create.jsp" >Add New User</a>
</c:if>
<br>
<a href="out">Cancel</a>
</body>
</html>
