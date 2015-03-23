<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <fmt:setLocale value="ru_Ru" />
                    <td><fmt:formatNumber type="currency"
                                          groupingUsed="false"
                                          value="${row.price}"
                                          maxFractionDigits="2"
                                          minFractionDigits="2"/>
                    </td>
                    <td><fmt:formatDate value="${row.date}"
                                        type="both"
                                        dateStyle="medium"
                                        timeStyle="medium"/>
                    </td>
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