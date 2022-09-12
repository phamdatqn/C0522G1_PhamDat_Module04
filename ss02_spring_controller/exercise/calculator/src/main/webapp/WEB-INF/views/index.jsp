<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 12/09/2022
  Time: 1:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/calculation">
    <input type="text" name="inputNumber1">
    <input type="text" name="inputNumber2"><br><br>
    <button type="submit" name="calculation" value="addition">Addition (+)</button>
    <button type="submit" name="calculation" value="subtraction">Subtraction (-)</button>
    <button type="submit" name="calculation" value="multiplication">Multiplication (X)</button>
    <button type="submit" name="calculation" value="division">Division (/)</button>
</form>
</body>
<p>
    Kết quả: ${result}
</p>
</html>
