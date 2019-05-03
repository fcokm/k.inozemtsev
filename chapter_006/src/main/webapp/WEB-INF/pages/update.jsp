<%@ page import="ru.job4j.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ru.job4j.datasources.DbStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        <jsp:directive.include file="/resources/css/main.css"/>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        <%@include file="/resources/js/main.js" %>
    </script>
</head>
<body>
<%
    User user = DbStore.getInstance().findById(Integer.parseInt(request.getParameter("id")));
%>
<div class="signup-form">
    <form action="user" method="post">
        <h2>Update User</h2>

        <div class="form-group has-error">
            <c:if test="${requestScope.isValidlogin eq 'invalid'}">
                <label class="control-label">Invalid "Login"</label>
            </c:if>
        </div>
        <div class="form-group">
            <input type="text" class="form-control " name="name"   placeholder="Enter name"
                            value= <%=user.getName()%>  required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="login" value= <%=user.getLogin()%> placeholder="Enter login" required="required">
        </div>
        <div class="form-group">
            <input type="email" class="form-control" name="email" value= <%=user.getEmail()%> placeholder="Enter email" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password"  value= <%=user.getPassword()%>  placeholder="Enter password"
                   required="required">
        </div>
        <div class="form-group" name="role">
            <select class="form-control">
                <c:choose>
                    <c:when test="${sessionScope.access != 'denied'}">
                        <option selected>Select Role</option>
                        <c:forEach var="role" items="${roleList}">
                            <option value="${role}">${role} </option>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="role" value="user">
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
        <div class="form-group">
            <select class="form-control" id="country" name="country">
            </select>
        </div>
        <div class="form-group">
            <select class="form-control" id="city" name="city">
            </select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg">Update</button>
            <input type="hidden" name="action" value="add">
            <input type="hidden" name="id" value=<%=user.getId()%>>
            <input type="hidden" name="jspPath" value="${pageContext.request.requestURI}"/>
        </div>
    </form>
   </div>
  </div>
</body>
</html>
