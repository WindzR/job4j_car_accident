<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>

<h3>Пожалуйста, отредактируйте данные о нарушении.</h3>
<br>

<form  action="<c:url value='/save?id=${accident.id}'/>" method='POST'>

    <table>
        <tr>
            <td>Название:</td>
            <td><input type='text' name='name' value="<c:out value="${accident.name}"/>"></td>
        </tr>
        <tr>
            <td>Статья:</td>
            <td><input type='text' name='article' value="<c:out value="${accident.article}"/>"></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type='text' name='text' value="<c:out value="${accident.text}"/>"></td>
        </tr>
        <tr>
            <td>Адрес:</td>
            <td><input type='text' name='address' value="<c:out value="${accident.address}"/>"></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>