<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <title>Accident</title>
</head>
<body>

<div class="container row">
    <div class="col s6 offset-s3">
        <h4 class="header center-align">Авторизация</h4>
        <div class="card horizontal">
            <div class="card-stacked row">
                <form class="col s12" action="<c:url value="/login" />" method="post">
                    <div class="card-content" style="padding-bottom: 0">
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="" id="username" type="text" name="username" class="validate" required>
                                <label class="active" for="username">Имя пользователя</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="" id="password" type="password" name="password" class="validate" required>
                                <label class="active" for="password">Пароль</label>
                            </div>
                            <c:if test="${not empty errorMessage}">
                                <div class="input-field col s12">
                                        <span class="helper-text" data-error="wrong" data-success="right" style="font-size: 14px">
                                                <c:out value="${errorMessage}"/>
                                        </span>
                                </div>
                            </c:if>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </div>
                    <div class="card-action right-align">
                        <div class="input-field col s12" style="display: inline-block; width: 50%; height: 36px">
                            <a href="<c:url value='/reg'/>">Регистрация</a>
                        </div>
                        <div class="input-field col s12" style="display: inline-block; width: 50%; ">
                            <button type="submit" class="waves-effect waves-light btn">
                                войти<i class="material-icons right">send</i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>