<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 09/09/2022
  Time: 5:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/rersult">
    <input type="text" name="inputNumber" placeholder="Nhập số tiền USD">
    <button type="submit"> Convert</button>
</form>
<p>Kết Quả:</p>
<input name="result" value="${result}" disabled>VNĐ
</body>
</html>
