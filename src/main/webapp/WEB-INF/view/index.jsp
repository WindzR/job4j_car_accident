<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Accident</title>
</head>

<body class="container">
<nav>
    <div class="nav-wrapper container light-blue darken-4">
        <a class="brand-logo center-align">AccidentApp</a>
    </div>
</nav>

<h2 class="col s12 center-align">Нарушения</h2>

<br>
<a href='<c:url value='/create'/>'>
    <i class="material-icons">edit</i>
</a>
<a href="<c:url value='/create'/>">Добавить инцидент</a>
<br>
<br>

<table class="table table-striped">
    <thead class="table-head light-blue">
    <tr>
        <th>#</th>
        <th>Нарушение</th>
        <th>Статья</th>
        <th>Описание</th>
        <th>Адрес</th>
        <th>Тип происшествия</th>
        <th>Обновить/Удалить</th>
    </tr>
    </thead>
    <tbody class="striped">

    <c:forEach items="${itemsList}" var="item" varStatus="count">
        
        <tr>
            <td><c:out value="${count.count}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td>
                <c:forEach items="${item.rules}" var="rule">
                    <c:out value="${rule.name}"/>
                </c:forEach>
            </td>
            <td><c:out value="${item.text}"/></td>
            <td>
                <c:out value="${item.address}"/>
            </td>
            <td>
                <c:out value="${item.type.name}"/>
            </td>
            <td>
                <a href='<c:url value="/update?id=${item.id}"/>'>
                    <i class="material-icons">edit</i>
                </a>
                <a href='<c:url value="/delete?id=${item.id}"/>'>
                    <i class="material-icons">delete</i>
                </a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>