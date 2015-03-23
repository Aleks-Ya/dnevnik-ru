<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<p style="color: red">Ошибка!</p>
<p>${requestScope["javax.servlet.error.message"]}</p>
<p><a href="index.html">На главную</a></p>
</body>
</html>
