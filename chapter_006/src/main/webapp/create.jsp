
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h3>Add New User</h3>
<div style="padding: 15px 5px">
    <form action=<%=request.getContextPath()%>"/user" method="post">
        Name:<br>
        <input type="text" name="name">
        <br>Login:<br>
        <input type="text" name="id">
        <br>Email:<br>
        <input type="text" name="email">
        <input type="hidden" name="action" value="add">
        <br><br>
        <input type="submit" value="Save">
    </form>
</div>
</body>
</html>
