<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 13/09/2022
  Time: 7:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<h2 style="color: red">${message}</h2>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Năm sinh</th>
        <th>Giới tính</th>
        <th>Quốc tịch</th>
        <th>Số CMND/Hộ chiếu</th>
        <th>Tên phương tiện</th>
    </tr>
   <c:forEach varStatus="status" var="declaration" items="${declarationList}">
       <tr>
           <td>${status.count}</td>
           <td>${declaration.name}</td>
           <td>${declaration.birthday}</td>
           <td>${declaration.gender}</td>
           <td>${declaration.country}</td>
           <td>${declaration.idCard}</td>
           <td>${declaration.tenPhuongTien}</td>
       </tr>
   </c:forEach>
</table>
<a href="/create"><button>create</button></a>
</body>
</html>
