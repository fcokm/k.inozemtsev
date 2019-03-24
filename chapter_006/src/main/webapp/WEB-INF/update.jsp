<%@ page import="ru.job4j.servlets.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<br>
<c:if test="${requestScope.isValidlogin eq 'invalid'}">
    <p style="color: red">User with this login is already registered</p>
</c:if>

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
            <c:if test="${sessionScope.access != 'denied'}">
                <tr>
                    <td>Role</td>
                    <td><select name="role" style=" width: 120px">
                        <c:forEach var="role" items="${roleList}">
                            <option  value="${role}">${role}</option>
                        </c:forEach>
                    </select>
                    </td>
                </tr>
            </c:if>
        </table>

        <br>
        <input type="submit" value="Edit & Save">
        <input type="hidden" name="jspPath" value="${pageContext.request.requestURI}"/>
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="loginUpdate" value=<%=user.getLogin()%>>
    </form>
</div>
</body>
</html>
