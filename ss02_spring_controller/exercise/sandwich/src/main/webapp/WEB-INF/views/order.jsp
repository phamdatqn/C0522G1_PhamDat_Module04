<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 12/09/2022
  Time: 1:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Bạn đã chọn bánh Sandwich có vị: </h2>
<c:forEach var="condiment" items="${condiment}">
    <p style="color: rebeccapurple;font-size: 30px">+ ${condiment}</p>
</c:forEach>
</body>
</html>
