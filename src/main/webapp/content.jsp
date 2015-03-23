<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<html>
<head>
    <title>Data base content</title>
</head>
<body>
<table border="1">
    <caption>Содержимое БД:</caption>
    <tr>
        <th>Идентификатор</th>
        <th>Код</th>
        <th>Наименование</th>
        <th>Цена</th>
        <th>Дата</th>
    </tr>
    <c:choose>
        <c:when test="${not empty requestScope.content}">
            <c:forEach var="row" items="${requestScope.content}">
                <tr>
                    <td>${row.id}</td>
                    <td>${row.code}</td>
                    <td>${row.name}</td>
                    <td>${row.price}</td>
                    <td>${row.date}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="5">База данных пустая</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>
<p><a href="index.html">На главную</a></p>
</body>
</html>