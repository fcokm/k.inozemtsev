<%@ page import="ru.job4j.servlets.MemoryDataStore" %>
<%@ page import="ru.job4j.servlets.User" %>
<%@ page import="ru.job4j.servlets.ValidateService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<h3>Add New User</h3>
<c:if test="${requestScope.isValidlogin eq 'invalid'}">
    <p style="color: red">User with this login is already registered</p>
</c:if>
<div style="padding: 15px 5px">
    <form action="user" method="post">
        Name:<br>
        <input type="text" name="name">
        <br>Login:<br>
        <input type="text" name="login">
        <br>Email:<br>
        <input type="text" name="email">
        <br>Password:<br>
        <input type="text" name="password">
        <c:choose>
            <c:when test="${sessionScope.access != 'denied'}">
                <br>Role:<br>
                <select name="role" style=" width: 120px">
                    <c:forEach  var="role" items="${roleList}">
                        <option  value="${role}">${role} </option>
                    </c:forEach>
                </select>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="role" value="user">
            </c:otherwise>
        </c:choose>
        <input type="hidden" name="action" value="add">
        <input type="hidden" name="jspPath" value="${pageContext.request.requestURI}"/>
        <br><br>
        <input type="submit" value="Save">
    </form>
</div>
</body>
</html>

