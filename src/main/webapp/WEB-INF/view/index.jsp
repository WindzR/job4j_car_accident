<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Accident</title>
</head>

<body class="container">
<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Описание</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${itemsList}" var="item" varStatus="count">
        <tr>
            <td><c:out value="${count.count}"/></td>
            <td><c:out value="${item}"/></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>