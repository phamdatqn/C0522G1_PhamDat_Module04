<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 09/09/2022
  Time: 7:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/search">
    <input type="text" name="search">
    <button type="submit">Dịch</button>
    <input type="text" disabled value="${result}">
</form>


</body>
</html>
