<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        <jsp:directive.include file="/resources/css/add.css"/>
    </style>
</head>
<body>
</div>
<div class="login-form">
    <form action="auth" method="post">
        <h2 class="text-center">Sign In</h2>
        <div class="form-group has-error">
            <c:if test="${requestScope.error eq 'invalid'}">
                <label class="control-label">Invalid "Login or Password"</label>
            </c:if>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class
                              ="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" class="form-control" placeholder="Login" name="login" required="required">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control" placeholder="Password" name="password" required="required">
                <input type="hidden" name="action" value="add">
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
    </form>
</div>
</body>
</html>
