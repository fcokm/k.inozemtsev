<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
 <div class="container">
    <div class="row">
        <div class="col-md-6" style="text-align:left;">
            <h3>CRUD Operation</h3>
        </div>
    </div>

    <div class="row">
        <div class="col-md-10">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>login</th>
                        <th>Email</th>
                        <th>Data</th>
                        <th>Country</th>
                        <th>City</th>
                        <th>Role</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
        <c:forEach var="user" items="${userList}">
                    <tbody>
                    <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.data}"/></td>
            <td><c:out value="${user.country}"/></td>
            <td><c:out value="${user.city}"/></td>
            <td><c:out value="${user.role}"/></td>
            <td>
            <form id="edit" action="user">
            <input type="hidden" name="id" value="${user.id}">
            <input type="hidden" name="page" value="update.jsp">
            <c:choose>
                <c:when test="${sessionScope.access != 'denied'}">
                    <button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                </c:when>
                <c:when test="${sessionScope.id eq user.id }">
                    <button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                </c:otherwise>
            </c:choose>
            </form>
            </td>

            <td>
            <form id="del" action="user" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <input type="hidden" name="action" value="delete">
            <c:choose>
                <c:when test="${sessionScope.access != 'denied'}">
                        <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>Delete</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>Delete</button>
                </c:otherwise>
            </c:choose>
             </form>
                 </td>
                    </tr>
                    </tbody>
           </c:forEach>
                </table>
                <div class="row">
                    <div class=" col-sm-6 ">
                         <a href="user?page=create.jsp" class="btn btn-primary  btn-xs" role="button" aria-pressed="true">Add user</a>
                         <a href="out" class="btn btn-primary  btn-xs" role="button" aria-pressed="true">Cancel</a>
                    </div>
                </div>
            </div>
        </div>
      </div>
    </div>
</body>
</html>

