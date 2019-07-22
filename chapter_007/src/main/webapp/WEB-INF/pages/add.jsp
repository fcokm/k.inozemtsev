<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        <jsp:directive.include file="/resources/css/add.css"/>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        <%@include file="/resources/js/main.js" %>
    </script>
</head>
<body>
<div class="signup-form">
    <form action="/" method="post">
        <h2>Add car</h2>

        <div class="form-group">
            <select class="form-control" id="mark">
                <option data-hidden="true">Марка</option>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" id="model" disabled>
                <option data-hidden="true">Модель</option>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" id="body">
                <option data-hidden="true">Кузов</option>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" id="engineType">
                <option data-hidden="true">Двигатель</option>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" id="engineVolum">
                <option data-hidden="true">Объем двигателя</option>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" id="gearbox">
                <option data-hidden="true">Коробка Передач</option>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" id="category">
                <option data-hidden="true">Категория</option>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" id="colour">
                <option data-hidden="true">Цвет</option>
            </select>
        </div>

        <div class="form-group">
            <select class="form-control" id="year">
                <option data-hidden="true">Год выпуска</option>
            </select>
        </div>

        <div class="form-group">
            <input type="text" class="form-control " id="mileage" name="name" placeholder="Пробег"
                   required="required">
        </div>

        <div class="form-group">
            <input type="text" class="form-control " id="price" name="price" placeholder="Цена"
                   required="required">
        </div>

        <div class="form-group">
            <button id="add" type="submit" class="btn btn-primary btn-lg">Добавить авто</button>
        </div>
    </form>
    <div>
        <form id="uploadForm" method="post" enctype="multipart/form-data" name="fileinfo">
            <div id="output" class="form-group">
            </div>
            <div class="form-group">
                <input type="file" name="sample2" id="fileUpload" data-field-type="bootstrap-file-filed"
                       accept="image/x-png,image/gif,image/jpeg">
            </div>
            <div class="form-group">
                <button id="upload" class="btn btn-primary">Загрузить фото</button>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
