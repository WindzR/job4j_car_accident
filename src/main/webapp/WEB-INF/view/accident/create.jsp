<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>

<h3>Пожалуйста, введите данные о нарушении.</h3>
<br>

<form  action="<c:url value='/save'/>" method='POST'>
    <table>
        <tr>
            <td>Название:</td>
            <td><input type='text' name='name'
                placeholder="name of accident"></td>
        </tr>
        <tr>
            <td>Статья:</td>
            <td><input type='text' name='article'
                placeholder="articles"></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type='text' name='text'
                placeholder="description of accident"></td>
        </tr>
        <tr>
            <td>Адрес:</td>
            <td><input type='text' name='address'
                placeholder="address"></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>