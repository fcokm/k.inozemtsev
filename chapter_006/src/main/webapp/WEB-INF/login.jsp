<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Authorization</h3>
<c:if test="${requestScope.error eq 'invalid'}">
    <p style="color: red">Invalid "Login or Password"</p>
    </c:if>

<div style=" padding: 15px 5px">
    <form  action="auth" method="post">
        <br>Login:<br>
        <input type="text" name="login">
        <br>Password:<br>
        <input type="password" name="password">
        <input type="hidden" name="action" value="add">
        <br>
        <input type="submit" value="Save">
    </form>
</div>
</body>
</html>
