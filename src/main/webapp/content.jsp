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
        <th>id</th>
        <th>code</th>
        <th>name</th>
        <th>price</th>
        <th>date</th>
    </tr>
    <c:forEach var="row" items="${requestScope.content}">
        <tr>
            <td>${row.id}</td>
            <td>${row.code}</td>
            <td>${row.name}</td>
            <td>${row.price}</td>
            <td>${row.date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>