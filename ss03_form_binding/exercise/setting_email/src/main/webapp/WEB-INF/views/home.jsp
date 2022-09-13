<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 13/09/2022
  Time: 10:54 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<h2 style="color: darkgreen">${message}</h2>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Languages</th>
        <th>Page size</th>
        <th>Spams filter</th>
        <th>Signature</th>
    </tr>
    <c:forEach varStatus="startus" var="email" items="${emailList}">
        <tr>
            <td><a href="/update/${email.id}">${startus.count}</a></td>
            <td>${email.languages}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
