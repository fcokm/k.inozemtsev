<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/main.js" />"></script>


</head>
<body>
<div id="root" class="container">
    <div class="auto-app" id="au">
        <div class="card-body">
            <h7 class="card-title">Объявления</h7>
            <c:if test="${sessionScope.userLogin != null}">
                <h4 class="card-subtitle mb-2 text-muted"> <c:out value="Hi ${sessionScope.userLogin} !"/>  </h4>
                <a href="/out" class="card-link">Выйти</a>
            </c:if>
        </div>
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="/WEB-INF/views/main.jsp">На главнаю</a>
            </li>
            <li class="nav-item">
          <%--      <a class="${sessionScope.userLogin != null ? 'nav-link active' : 'nav-link disabled'}"
                   href="/?page=add.jsp">Продать</a>--%>
              <a class="nav-link active" data-toggle="tab" href="add">Продать</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="/auth">Вход</a>
            </li>
        </ul>
        <fieldset class="form-group">
            <div class="form-check" >
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" id="cf" value="">
                     Выбрать авто с фото
                </label>
            </div>
            <div class="form-check">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" id="cd" value="">
                    Выбрать авто за последний день
                </label>
            </div>
            <select class="custom-select"  id="mark" style="width: 30%;">
                    <option data-hidden="true">Марка</option>
            </select>
        </fieldset>

    </div>
</div>
</body>
</html>