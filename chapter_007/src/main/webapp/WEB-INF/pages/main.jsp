<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://bootswatch.com/4/superhero/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="bootswatch.com/4/superhero/bootstrap.min.css">

    <script type="text/javascript">
        <%@include file="resources/js/main.js" %>
    </script>
</head>
<body>
<div id="root" class="container">

    <div class="card-body">
        <h7 class="card-title">Объявления</h7>
        <c:if test="${sessionScope.userLogin != null}">
            <h4 class="card-subtitle mb-2 text-muted"> <c:out value="${sessionScope.userLogin}"/>  </h4>
            <a href="/out" class="card-link">Выйти</a>
        </c:if>

    </div>

    <div class="auto-app" id="un">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="/main.jsp">На главнаю</a>
            </li>
            <li class="nav-item">
                <a class="${sessionScope.userLogin != null ? 'nav-link active' : 'nav-link disabled'}"
                   href="/add.jsp">Продать</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="/auth">Вход</a>
            </li>
        </ul>

        <fieldset class="form-group">
            <legend>Checkboxes</legend>
            <div class="form-check">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" value="" checked="">
                    Показать авто с фото
                </label>
            </div>
                <select class="custom-select" style="width: 30%;">
                    <option selected="">Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>



            <button type="submit" class="btn btn-primary">Submit</button>
        </fieldset>




        <c:forEach var="car" items="${carList}">
            <div class="auto-ads jumbotron rounded">
                          <c:if test="${car.base64DataString != null}">
                              <img src="data:image/png;base64,  ${car.base64DataString}">
                          </c:if>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><span class="term">Марка: </span><span><c:out value="${car.markCar.name}"/></span></li>
                    <li class="list-group-item"><span class="term">Модель: </span><span><c:out value="${car.carModel.name}"/></span></li>
                    <li class="list-group-item"><span class="term">Объем двигателя:  </span><span><c:out value="${car.engineVolum.name}"/></span></li>
                    <li class="list-group-item"><span class="term">Тип двигателя:  </span><span><c:out value="${car.engineType.name}"/></span></li>
                    <li class="list-group-item"><span class="term">Цвет:  </span><span><c:out value="${car.colour.name}"/></span></li>
                    <li class="list-group-item"><span class="term">Год выпуска: </span><span><c:out value="${car.year.name}"/></span></li>
                    <li class="list-group-item"><span class="term">Пробег:  </span><span><c:out value="${car.mileage}"/></span></li>
                    <li class="list-group-item"><span class="term">Цена:  </span><span><c:out value="${car.price}"/></span></li>
                    <li class="list-group-item"><span class="term">Статус:  </span><span><c:out value="${car.status}"/></span></li>

                    <li class="list-group-item"><span class="term"></span>
                        <c:set var="userId">${car.user.id}</c:set>
                        <c:if test="${sessionScope.userId == userId}">
                            <select class="selectpicker" id="sl">
                                <option data-hidden="true">Статус</option>
                                <option value="isForSale">Продается</option>
                                <option value="sales">Продана</option>
                            </select>
                        </c:if>
                     </li>
                </ul>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>

